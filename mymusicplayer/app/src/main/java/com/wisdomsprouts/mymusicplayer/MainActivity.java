package com.wisdomsprouts.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;


    Button play , pause , stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        play = findViewById(R.id.play);

        pause = findViewById(R.id.pause);

        stop = findViewById(R.id.stop);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (player == null)
                    {
                        player = MediaPlayer.create(MainActivity.this, R.raw.song);

                    }

                    player.start();

                Toast.makeText(MainActivity.this, "Song Started", Toast.LENGTH_SHORT).show();

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null) {
                    player.pause();
                }
                Toast.makeText(MainActivity.this, "Song Paused", Toast.LENGTH_SHORT).show();

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null)
                {
                    player.release();
                    player = null;

                    Toast.makeText(MainActivity.this, "MediaPlayer released", Toast.LENGTH_SHORT).show();

                }

            }
        });




    }
}
