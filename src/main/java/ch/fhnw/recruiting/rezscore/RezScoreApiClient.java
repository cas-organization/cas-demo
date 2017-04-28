package ch.fhnw.recruiting.rezscore;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RezScoreApiClient {
    @RequestLine("POST /grade")
    @Headers("Content-Type: multipart/form-data")
    String getScore(@Param("resume") byte[] file);
}
