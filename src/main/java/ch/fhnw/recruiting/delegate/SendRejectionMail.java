package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.mail.Mail;
import ch.fhnw.recruiting.mail.MailAdapter;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendRejectionMail implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendRejectionMail.class);

    private final MailAdapter mailAdapter;

    public SendRejectionMail(MailAdapter mailAdapter) {
        this.mailAdapter = mailAdapter;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Send rejection mail to candidate {}", execution);

        String candidateMail = (String) execution.getVariable("candidateMail");
        String lastName = (String) execution.getVariable("candidateLastName");
        String firstName = (String) execution.getVariable("candidateFirstName");

        String content = String.format("Dear %s %s<br><br>%s", lastName, firstName, "We are so sorry");
        Mail mail = new Mail(candidateMail, "Rejection Letter", content);

        mailAdapter.sendMail(mail);
    }



}
