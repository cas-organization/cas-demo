package ch.fhnw.recruiting.mail;

import ch.fhnw.recruiting.util.RestClientFactory;

public class MailAdapter {

    private final MailApiClient mailApiClient;

    public MailAdapter(String url) {
        this.mailApiClient = RestClientFactory.createClient(url, MailApiClient.class);
    }

    public String sendMail(Mail mail) {
        return mailApiClient.sendMail(mail);
    }
}
