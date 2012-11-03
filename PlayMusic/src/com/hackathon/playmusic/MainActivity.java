package com.hackathon.playmusic;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private MediaPlayer player;

    private static String username = "goldberg.chain.reaction";
    private static String passwd = "n0n0n0n0";
    private static String email = "goldberg.chain.reaction@gmail.com";
    private static String host = "imap.gmail.com";

    private static class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthenticator() {
            return new PasswordAuthentication(username, passwd);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        player = MediaPlayer.create(this, R.raw.georgia);

        Properties props = new Properties();
        props.put("mail.imaps.host", host);
        props.put("mail.imaps.debug", "true");
        props.put("mail.imaps.starttls.enable", "true");
        props.put("mail.imaps.auth", "true");
        props.put("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props, new SMTPAuthenticator());

        try {

            Store store = session.getStore();
            store.connect(host, email, passwd);

            Folder inbox; Message[] msgs;
            TextView tv = (TextView) findViewById(R.id.tv);

            inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_ONLY);
            msgs = inbox.getMessages();
            int count = msgs.length;
            while (msgs.length <= count) {
                inbox.close(false);
                java.lang.Thread.sleep(2000);
                tv.setText(msgs.length + " messages in INBOX.");
                inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);
                msgs = inbox.getMessages();
            }

            playSong();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void playSong() {
        player.start();
    }
}
