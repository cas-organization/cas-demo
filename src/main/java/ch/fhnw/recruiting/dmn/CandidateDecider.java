package ch.fhnw.recruiting.dmn;

import ch.fhnw.recruiting.delegate.RecommendEligibility;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class CandidateDecider {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendEligibility.class);

    private final DmnEngine dmnEngine = DmnEngineConfiguration
            .createDefaultDmnEngineConfiguration()
            .buildEngine();

    public boolean decideEligible(String grade) throws IOException {
        if (grade == null) {
            return false;
        }

        String transformedGrade = transformGrade(grade);

        return decide(transformedGrade);
    }

    private boolean decide(String transformedGrade) {
        LOGGER.info("Decide is candidate eligible grade={}", transformedGrade);

        VariableMap variables = Variables
                .putValue("grade", transformedGrade);

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("bpmn/candidate_eligible.dmn");
        DmnDecision decision = dmnEngine.parseDecision("decision", inputStream);

        DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(decision, variables);

        return result.getSingleEntry();
    }

    private static String transformGrade(String grade) {
        return grade.replace("-", "").replace("+", "").trim().toUpperCase();
    }

}
