package com.wisdomsprouts.currancyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button b1;

    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);

        e1 = findViewById(R.id.editText);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rupee = Double.parseDouble(e1.getText().toString());


                double doller = rupee / 70 ;

                String value = "Converted $ value is :"+doller;

                Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();


            }
        });
    }
}
