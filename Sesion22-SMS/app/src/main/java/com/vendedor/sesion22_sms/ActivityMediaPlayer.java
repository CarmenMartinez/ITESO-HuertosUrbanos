package com.vendedor.sesion22_sms;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class ActivityMediaPlayer extends AppCompatActivity {

    protected EditText song;
    protected Button play, stop;
    protected MediaPlayer player

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        song = (EditText) findViewById(R.id.activity_media_song);
        play = (Button) findViewById(R.id.activity_media_play);
        stop = (Button) findViewById(R.id.activity_media_stop);

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri myUri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/"
                + Environment.DIRECTORY_MUSIC + "/"
                + song.getText().toString());

                try {
                    MediaPlayer player = new MediaPlayer();
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(ActivityMediaPlayer.this, myUri);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null && player.isPlaying()) {
                    player.stop();
                }
            }
        });
    }


}
