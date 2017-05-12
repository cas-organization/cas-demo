package ch.fhnw.recruiting.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;

class TextFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextFileReader.class);

    String readTextFile(String path) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
                return buffer.lines().collect(joining("\n"));
            }
        } catch (IOException e) {
            LOGGER.warn("Error reading file with path={}", path, e);
            return "";
        }
    }
}
