package ch.fhnw.recruiting.dmn;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CandidateDeciderTest {
    @Test
    public void decideEligible() throws Exception {
        CandidateDecider candidateDecider = new CandidateDecider();

        assertThat(candidateDecider.decideEligible("A"), is(true));
        assertThat(candidateDecider.decideEligible("B"), is(true));
        assertThat(candidateDecider.decideEligible("C"), is(false));
    }
}