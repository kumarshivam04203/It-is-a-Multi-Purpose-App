package com.codewithabhijeet.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MusicPlayer extends AppCompatActivity {

    RadioButton b1,b2;
    MediaPlayer mp,mp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        b1=(RadioButton) findViewById(R.id.radioButton);
        b2=(RadioButton) findViewById(R.id.radioButton7);
        mp=MediaPlayer.create(this,R.raw.tumileya);
        mp1=MediaPlayer.create(this,R.raw.banjare);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               mp.start();

           }
       });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                    mp1.start();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                mp1.start();
            }
        });
    }
}