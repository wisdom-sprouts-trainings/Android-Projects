package com.wisdomsprouts.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);

        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.passowrd);

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }
            });


           b1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   final  String email = e1.getText().toString().trim();
                   final  String password = e2.getText().toString().trim();
//                   Toast.makeText(MainActivity.this,email,Toast.LENGTH_LONG).show();

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


                   auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful())
                           {
                               Toast.makeText(MainActivity.this,"user created",Toast.LENGTH_LONG).show();

                               Intent i = new Intent(MainActivity.this,Main2Activity.class);
                               startActivity(i);

                           }
                           else
                           {
                               Toast.makeText(MainActivity.this,"error created",Toast.LENGTH_LONG).show();

                           }
                       }
                   });
               }
           });
    }


}
