package ch.fhnw.recruiting.dmn;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import java.io.IOException;
import java.io.InputStream;

public class CandidateDecider {

    private final DmnEngine dmnEngine = DmnEngineConfiguration
            .createDefaultDmnEngineConfiguration()
            .buildEngine();

    public boolean decideEligible(String grade) throws IOException {
        VariableMap variables = Variables
                .putValue("grade", grade);

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("bpmn/candidate_eligible.dmn");
        DmnDecision decision = dmnEngine.parseDecision("decision", inputStream);

        DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(decision, variables);

        return result.getSingleEntry();
    }

}
