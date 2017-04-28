package ch.fhnw.recruiting;

import ch.fhnw.recruiting.mail.MailAdapter;
import ch.fhnw.recruiting.rezscore.RezScoreAdapter;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableProcessApplication
public class RecruitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitingApplication.class, args);
    }

    @Bean
    public RezScoreAdapter rezScoreAdapter(@Value("${endpoint.rezscore}") String url) {
        return new RezScoreAdapter(url);
    }

    @Bean
    public MailAdapter mailAdapter(@Value("${endpoint.mail}") String url) {
        return new MailAdapter(url);
    }

}
