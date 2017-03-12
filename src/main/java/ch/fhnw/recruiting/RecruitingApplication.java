package ch.fhnw.recruiting;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableProcessApplication
public class RecruitingApplication {

    private static final Logger logger = LoggerFactory.getLogger(RecruitingApplication.class);

    private static int PORT;

    public static void main(String[] args) {
        SpringApplication.run(RecruitingApplication.class, args);
        logger.info("You can reach the web app under: http://localhost:{}/", PORT);
    }

    @Component
    public static class ServletContainerListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

        @Override
        public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
            PORT = event.getEmbeddedServletContainer().getPort();
        }

    }
}
