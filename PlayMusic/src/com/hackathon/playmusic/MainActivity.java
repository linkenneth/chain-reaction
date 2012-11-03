package com.hackathon.playmusic;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends Activity {

    private MediaPlayer player;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        player = MediaPlayer.create(this, R.raw.georgia);
    }

    public void playSong (View view) {
        Button pButton = (Button) view;
        player.start();
        pButton.setText("Stop Playing");
    }
}
