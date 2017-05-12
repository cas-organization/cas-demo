package ch.fhnw.recruiting.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TextFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextFileReader.class);

    String readTextFile(String path) {
        try {
            URL resource = getClass().getClassLoader().getResource(path);
            if (resource == null) {
                LOGGER.warn("No file found with path={}", path);
                return "";
            }

            Path filePath = Paths.get(resource.toURI());
            byte[] bytes = Files.readAllBytes(filePath);
            return new String(bytes);
        } catch (IOException | URISyntaxException e) {
            LOGGER.warn("Error reading file with path={}", path, e);
            return "";
        }
    }
}
