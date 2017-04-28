package ch.fhnw.recruiting.rezscore;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.codec.StringDecoder;
import feign.form.FormEncoder;
import feign.hystrix.HystrixFeign;
import feign.slf4j.Slf4jLogger;

public class RestClientFactory {

    static {
        System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "20000");
    }

    static <T> T createClient(String url, Class<T> clazz) {
        return createDeafultClient().target(clazz, url);
    }

    public static <T> T createClientWithFallback(String url, Class<T> clazz, T fallback) {
        return createDeafultClient().target(clazz, url, fallback);
    }

    private static HystrixFeign.Builder createDeafultClient() {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        return HystrixFeign.builder()
                .encoder(new FormEncoder())
                .decoder(new StringDecoder())
                .logger(new Slf4jLogger(RestClientFactory.class))
                .logLevel(Logger.Level.HEADERS);
    }
}
