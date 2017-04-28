package ch.fhnw.recruiting.mail;

import feign.Headers;
import feign.RequestLine;

public interface MailApiClient {
    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    String sendMail(Mail mail);
}
