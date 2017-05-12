package ch.fhnw.recruiting.delegate;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class TextFileReaderTest {
    @Test
    public void readTextFile() throws Exception {
        String body = TextFileReader.readTextFile("templates/rejection-mail.txt");

        assertThat(body, containsString("FHNW"));
    }
}