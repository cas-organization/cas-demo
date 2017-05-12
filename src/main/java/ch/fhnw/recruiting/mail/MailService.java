package ch.fhnw.recruiting.mail;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailService {
    private final MailAdapter mailAdapter;

    public MailService(MailAdapter mailAdapter) {
        this.mailAdapter = mailAdapter;
    }

    public void sendMail(DelegateExecution execution, String subject, String template) throws IOException {
        String candidateMail = (String) execution.getVariable("candidateMail");
        String lastName = (String) execution.getVariable("candidateLastName");
        String firstName = (String) execution.getVariable("candidateFirstName");
        String body = TextFileReader.readTextFile(template);

        String content = String.format("Dear %s %s<br><br>%s", lastName, firstName, body);
        Mail mail = new Mail(candidateMail, subject, content);

        mailAdapter.sendMail(mail);
    }

}
