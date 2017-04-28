package ch.fhnw.recruiting.mail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mail {
    private final String receiver;
    private final String subject;
    private final String content;

    public Mail(String receiver, String subject, String content) {
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
    }

    @JsonProperty("value1")
    public String getReceiver() {
        return receiver;
    }

    @JsonProperty("value2")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("value3")
    public String getContent() {
        return content;
    }
}
