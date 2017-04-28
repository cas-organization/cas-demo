package ch.fhnw.recruiting.rezscore;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RezScoreXmlParserTest {

    public static final String XML = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
            "<rezscore>\n" +
            "    <score>\n" +
            "        <grade>B-</grade>\n" +
            "        <grade_headline>Your Resume is Good</grade_headline>\n" +
            "        <grade_blurb>This resume provides a good picture of your value to an employer, but it can do better.  To create a better resume, keep your resume concise and impactful.  Make sure every word counts, and use vivid language to get employers excited.</grade_blurb>\n" +
            "        <percentile>72</percentile>\n" +
            "        <percentile_suffix>nd</percentile_suffix>\n" +
            "        <normal_img>http://rezscore.com/images/bells/BlueBell99.png</normal_img>\n" +
            "        <brevity_score>70</brevity_score>\n" +
            "        <impact_score>91</impact_score>\n" +
            "        <depth_score>99</depth_score>\n" +
            "        <email>NATALIA.BROUWER@GMAIL.COM</email>\n" +
            "        <phone>-1</phone>\n" +
            "        <job_keywords>        </job_keywords>\n" +
            "        <rez_id>TSFqX6pchns~</rez_id>\n" +
            "    </score>\n" +
            "    <industry>\n" +
            "        <first_industry_match>Business</first_industry_match>\n" +
            "        <first_industry_conf>48.1</first_industry_conf>\n" +
            "        <second_industry_match>Administrative</second_industry_match>\n" +
            "        <second_industry_conf>13.5</second_industry_conf>\n" +
            "        <third_industry_match>Education/Training</third_industry_match>\n" +
            "        <third_industry_conf>8</third_industry_conf>\n" +
            "    </industry>\n" +
            "    <language>\n" +
            "        <word>\n" +
            "            <string>accounting</string>\n" +
            "            <val>0.66666666666667</val>\n" +
            "        </word>\n" +
            "        <word>\n" +
            "            <string>positions</string>\n" +
            "            <val>0.625</val>\n" +
            "        </word>\n" +
            "        <word>\n" +
            "            <string>list</string>\n" +
            "            <val>0.58333333333333</val>\n" +
            "        </word>\n" +
            "        <word>\n" +
            "            <string>change</string>\n" +
            "            <val>0.57142857142857</val>\n" +
            "        </word>\n" +
            "        <word>\n" +
            "            <string>finance</string>\n" +
            "            <val>0.53846153846154</val>\n" +
            "        </word>\n" +
            "    </language>\n" +
            "    <advice>\n" +
            "        <tip>\n" +
            "            <short>Do not mention or provide references</short>\n" +
            "            <long>It is assumed you'll provide references upon request.  Do not waste space in your resume to confirm this.</long>\n" +
            "        </tip>\n" +
            "        <tip>\n" +
            "            <short>Don't use first person language</short>\n" +
            "            <long>It's improper to use first person language (i.e. me, myself, I) in your resume</long>\n" +
            "        </tip>\n" +
            "        <tip>\n" +
            "            <short>Your outstanding education puts your resume into the top tier.</short>\n" +
            "            <long>An excellent academic pedigree makes a difference in a tight job market.  You're in the top 10%</long>\n" +
            "        </tip>\n" +
            "    </advice>\n" +
            "    <file>\n" +
            "        <size>545180</size>\n" +
            "        <encoding>PDF document, version 1.6</encoding>\n" +
            "        <extension>pdf</extension>\n" +
            "        <lang>en</lang>\n" +
            "    </file>\n" +
            "    <extended>\n" +
            "        <unix_fail>0</unix_fail>\n" +
            "        <kincaid_score>16.2</kincaid_score>\n" +
            "        <ari_score>23.9</ari_score>\n" +
            "        <colman_liau_score></colman_liau_score>\n" +
            "        <flesch_index>31.6/100</flesch_index>\n" +
            "        <fog_index>20.8</fog_index>\n" +
            "        <lix_score>80.6</lix_score>\n" +
            "        <lix_school_year>12</lix_school_year>\n" +
            "        <smog_grading>17.1</smog_grading>\n" +
            "        <passive_sentence_pct>0</passive_sentence_pct>\n" +
            "        <avg_syllables>1.72</avg_syllables>\n" +
            "        <sentence_length>29.6</sentence_length>\n" +
            "        <short_sentence_pct>60</short_sentence_pct>\n" +
            "        <short_sentence_max>25</short_sentence_max>\n" +
            "        <long_sentence_pct>30</long_sentence_pct>\n" +
            "        <long_sentence_min>40</long_sentence_min>\n" +
            "        <wordcount>305</wordcount>\n" +
            "        <avg_syllable_dev>0.13</avg_syllable_dev>\n" +
            "        <is_resume_pct>1.0713121090909</is_resume_pct>\n" +
            "        <has_linkedin>0</has_linkedin>\n" +
            "        <has_objective_section>0</has_objective_section>\n" +
            "        <has_references>1</has_references>\n" +
            "        <years_experience>-1</years_experience>\n" +
            "        <is_working>-1</is_working>\n" +
            "        <pct_buzzwords>0.053627760252366</pct_buzzwords>\n" +
            "        <pct_numbers>0.04416403785489</pct_numbers>\n" +
            "        <pct_whitespace>0.037854889589905</pct_whitespace>\n" +
            "        <pct_adverbs>0.0031545741324921</pct_adverbs>\n" +
            "        <count_raw>317</count_raw>\n" +
            "        <count_nf>305</count_nf>\n" +
            "    </extended>\n" +
            "    <text>\n" +
            "        <binlink>\n" +
            "\t\t\thttp://rezscore.com/a/112084/view/TSFqX6pchns~.pdf\n" +
            "\t\t</binlink>\n" +
            "        <htmllink>\n" +
            "\n" +
            "\t\t\thttp://rezscore.com/a/112084/view/TSFqX6pchns~.html\n" +
            "\t\t</htmllink>\n" +
            "        <txtlink>\n" +
            "\t\t\thttp://rezscore.com/a/112084/view/TSFqX6pchns~.txt\n" +
            "\t\t</txtlink>\n" +
            "    </text>\n" +
            "</rezscore>";

    @Test
    public void parseXml() throws Exception {
        RezScoreXmlParser rezScoreXmlParser = new RezScoreXmlParser();

        RezScore rezScore = rezScoreXmlParser.parseXml(XML);

        assertThat(rezScore.getEmail(), is("NATALIA.BROUWER@GMAIL.COM"));
        assertThat(rezScore.getGrade(), is("B-"));
    }
}