package ch.fhnw.recruiting.delegate;

import ch.fhnw.recruiting.dmn.CandidateDecider;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RecommendEligibility implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendEligibility.class);

    private final CandidateDecider candidateDecider = new CandidateDecider();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Recommend is candidate eligible {}", execution);

        String rezScoreGrade = (String) execution.getVariable("rezScoreGrade");
        boolean eligible = candidateDecider.decideEligible(rezScoreGrade);

        LOGGER.info("Recommend candidate {}", eligible);

        execution.setVariable("eligibleRecommendation", eligible);
    }

}
