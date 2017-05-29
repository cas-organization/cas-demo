package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.mail.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;



@Component
public class AcknowledgementMail implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcknowledgementMail.class);

    private final MailService mailService;

    public AcknowledgementMail(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Send submit mail to candidate {}", execution);
        mailService.sendMail(execution, "Thanks for your application", "templates/submit-mail.txt");

        LOGGER.info("Start upload cv {}", execution);
    }


}
