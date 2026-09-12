package week5;

import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        double getCompositeScore() {
            return cgpa * 10 + codingScore / 2.0;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(),
                                  this.getCompositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa)) {
                shortlisted[count] = candidates[i];
                count++;
            } else if (Candidate.isEligible(
                    candidates[i].cgpa,
                    candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Candidate[] result = new Candidate[count];

        for (int i = 0; i < count; i++) {
            result[i] = shortlisted[i];
        }

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output = output
                    + (i + 1)
                    + ". "
                    + result[i].name
                    + " ("
                    + result[i].getCompositeScore()
                    + ")";

            if (i < result.length - 1) {
                output = output + " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
