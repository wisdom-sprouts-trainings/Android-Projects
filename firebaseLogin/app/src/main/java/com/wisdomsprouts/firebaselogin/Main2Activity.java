package com.wisdomsprouts.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        auth = FirebaseAuth.getInstance();
        b1 = findViewById(R.id.new_login);
        e1 = findViewById(R.id.email_login);
        e2 = findViewById(R.id.password_login);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final  String email = e1.getText().toString().trim();
                final  String password = e2.getText().toString().trim();
                if(email.isEmpty())
                {
                    e1.setError("EMail is needed");
                    return;
                }
                if(password.isEmpty())
                {
                    e2.setError("password is needed");
                    return;
                }

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Main2Activity.this,"login successs",Toast.LENGTH_LONG).show();

                                    Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(Main2Activity.this,"error"+task.getException().getMessage(),Toast.LENGTH_LONG).show();

                                }

                                // ...
                            }
                        });


            }
        });
    }
}
