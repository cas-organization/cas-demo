package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.rezscore.RezScore;
import ch.fhnw.recruiting.rezscore.RezScoreAdapter;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class CvAnalyzeDelegate implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(CvAnalyzeDelegate.class);

    private final RezScoreAdapter rezScoreAdapter;

    public CvAnalyzeDelegate(RezScoreAdapter rezScoreAdapter) {
        this.rezScoreAdapter = rezScoreAdapter;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Start upload cv {}", execution);

        RezScore score = getRezScore(execution);

        if (score != null) {
            execution.setVariable("rezScoreGrade", score.getGrade());
            execution.setVariable("rezScoreImpactScore", score.getImpactScore());
            execution.setVariable("rezScoreFirstIndustry", score.getFirstIndustry());
            execution.setVariable("rezScoreSecondIndustry", score.getSecondIndustry());
        }
    }

    private RezScore getRezScore(DelegateExecution execution) {
        try {
            ByteArrayInputStream cv = (ByteArrayInputStream) execution.getVariable("candidateCv");
            RezScore score = rezScoreAdapter.getScore(read(cv));
            LOGGER.info("Got answer from RezScore {}", score);
            return score;
        } catch (Exception ex) {
            LOGGER.error("Error getting score from RezScore.", ex);
        }
        return null;
    }

    private byte[] read(ByteArrayInputStream bais) throws IOException {
        byte[] array = new byte[bais.available()];
        bais.read(array);

        return array;
    }

}
