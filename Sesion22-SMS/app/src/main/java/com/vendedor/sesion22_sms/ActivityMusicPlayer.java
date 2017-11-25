package com.vendedor.sesion22_sms;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ActivityMusicPlayer extends AppCompatActivity {

    protected ImageButton forward, backward, pause, play;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        forward = (ImageButton) findViewById(R.id.activity_music_forward);
        backward = (ImageButton) findViewById(R.id.activity_music_backward);
        pause = (ImageButton) findViewById(R.id.activity_music_pause);
        play = (ImageButton) findViewById(R.id.activity_music_play);

        mediaPlayer = MediaPlayer.create(this, R.raw.rocketbrothers);

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
    }
}
