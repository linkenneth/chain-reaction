package com.chain.music;

import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import java.util.ArrayList;
import android.media.MediaPlayer;

public class MainActivity extends Activity {

    private ArrayList<EmailListener> listeners = new ArrayList<EmailListener>();

    private MediaPlayer player = MediaPlayer.create(this, R.raw.georgia);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void addListener(EmailListener listener) {
        this.listeners.add(listener);
    }

    public void emailTriggerHandler() {
        System.out.println("New email!");
    }

    public void playSong (View view) {
        if (!player.isPlaying()) {
            player.start();
            Button pButton = (Button) findViewById(R.id.play_button);
            pButton.setText("Stop Playing");
        }
    }

}
