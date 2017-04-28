package ch.fhnw.recruiting.rezscore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RezScoreXmlParser {

    RezScore parseXml(String xml) {
        String grade = extractValue(xml, "grade");
        String email = extractValue(xml, "email");
        String impactScore = extractValue(xml, "impact_score");
        String firstIndustry = extractValue(xml, "first_industry_match");
        String secondIndustry = extractValue(xml, "second_industry_match");

        return new RezScore(grade, email, impactScore, firstIndustry, secondIndustry);
    }

    private String extractValue(String xml, final String fieldName) {
        Pattern pattern = Pattern.compile("<" + fieldName + ">(.+)<\\/" + fieldName + ">");
        Matcher matcher = pattern.matcher(xml);

        if(matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

}
