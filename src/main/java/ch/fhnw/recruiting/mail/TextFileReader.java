package ch.fhnw.recruiting.mail;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class TextFileReader {
    static String readTextFile(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
        return new String(bytes);
    }
}
