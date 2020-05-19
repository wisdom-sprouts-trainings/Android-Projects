package com.wisdomsprouts.mynotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btn);



        final NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_action_name)
                .setContentTitle("welcome")
                .setContentText("hi this is my testing notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.notify(100,builder.build());
            }
        });




    }
}
