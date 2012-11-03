package com.chain.music;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<EmailListener> listeners = new ArrayList<EmailListener>();

    /** Called when the activity is first created. */
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

}
