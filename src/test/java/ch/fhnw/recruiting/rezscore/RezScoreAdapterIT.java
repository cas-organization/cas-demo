package ch.fhnw.recruiting.rezscore;

import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@Ignore
public class RezScoreAdapterIT {
    @Test
    public void getGrade() throws Exception {
        RezScoreAdapter rezScoreAdapter = new RezScoreAdapter("https://rezscore.com/a/112084");

        byte[] file = Files.readAllBytes(Paths.get("./src/test/resources/CV_Natalia_Brouwer_2016.pdf"));

        RezScore score = rezScoreAdapter.getScore(file);

        assertThat(score.getEmail(), containsString("NATALIA.BROUWER"));
    }
}