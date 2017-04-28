package ch.fhnw.recruiting.mail;

import org.junit.Test;

public class MailAdapterIT {
    @Test
    public void sendMail() throws Exception {
        MailAdapter mailAdapter = new MailAdapter("https://maker.ifttt.com/trigger/send_mail/with/key/m-fpW1lKoHE5kzbhe5IPUIkuD5J4L6OeNYzrHzpCXPK");
        mailAdapter.sendMail(new Mail("matthias.brun@gmail.com", "Test", "Content"));
    }

}