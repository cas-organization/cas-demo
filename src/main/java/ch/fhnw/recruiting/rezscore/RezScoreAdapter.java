package ch.fhnw.recruiting.rezscore;

public class RezScoreAdapter {

    private final RezScoreApiClient rezScoreApiClient;

    public RezScoreAdapter(String url) {
        this.rezScoreApiClient = RestClientFactory.createClient(url, RezScoreApiClient.class);
    }

    public RezScore getScore(byte[] file) {
        String xml = rezScoreApiClient.getScore(file);
        return new RezScoreXmlParser().parseXml(xml);
    }
}
