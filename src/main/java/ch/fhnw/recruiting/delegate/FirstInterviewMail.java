package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.mail.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FirstInterviewMail implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstInterviewMail.class);

    private final MailService mailService;

    public FirstInterviewMail(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Send first interview mail to candidate {}", execution);
        mailService.sendMail(execution, "We will contact you for first interview", "templates/first-interview-mail.txt");


    }


}