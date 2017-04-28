package ch.fhnw.recruiting.rezscore;

public class RezScore {

    private final String grade;
    private final String email;
    private final String impactScore;
    private final String firstIndustry;
    private final String secondIndustry;

    public RezScore(String grade, String email, String impactScore, String firstIndustry, String secondIndustry) {
        this.grade = grade;
        this.email = email;
        this.impactScore = impactScore;
        this.firstIndustry = firstIndustry;
        this.secondIndustry = secondIndustry;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getImpactScore() {
        return impactScore;
    }

    public String getFirstIndustry() {
        return firstIndustry;
    }

    public String getSecondIndustry() {
        return secondIndustry;
    }

    @Override
    public String toString() {
        return "RezScore{" +
                "grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                ", impactScore='" + impactScore + '\'' +
                ", firstIndustry='" + firstIndustry + '\'' +
                ", secondIndustry='" + secondIndustry + '\'' +
                '}';
    }
}
