package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.mail.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class SecondInterviewMail implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondInterviewMail.class);

    private final MailService mailService;

    public SecondInterviewMail(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Send second interview mail to candidate {}", execution);
        mailService.sendMail(execution, "We will contact you for second interview", "templates/second-interview-mail.txt");


    }


}