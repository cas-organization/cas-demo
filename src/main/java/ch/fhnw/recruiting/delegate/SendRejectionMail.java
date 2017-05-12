package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.mail.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendRejectionMail implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendRejectionMail.class);

    private final MailService mailService;

    public SendRejectionMail(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Send rejection mail to candidate {}", execution);
        mailService.sendMail(execution, "Rejection Letter", "templates/rejection-mail.txt");
    }

}
