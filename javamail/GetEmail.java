import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;

public class GetEmail {

    private static String username = "goldberg.chain.reaction";
    private static String passwd = "n0n0n0n0";
    private static String email = "goldberg.chain.reaction@gmail.com";
    private static String host = "imap.gmail.com";
    private static int port = 465;

    private static class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthenticator() {
            return new PasswordAuthentication(username, passwd);
        }
    }

    public static void main(String[] args) {

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

            inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_ONLY);
            msgs = inbox.getMessages();
            int count = msgs.length;
            while (msgs.length <= count) {
                inbox.close(false);
                java.lang.Thread.sleep(2000);
                System.out.println(msgs.length + " messages in INBOX.");
                inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);
                msgs = inbox.getMessages();
            }

            System.out.println("=== MUSIC TRIGGER ===");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

