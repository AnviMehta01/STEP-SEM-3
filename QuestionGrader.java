package week8;

import java.util.*;
import java.io.*;
import java.util.regex.*;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String word : keywords) {
            if (answer.toLowerCase().contains(
                    word.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        if (count == 1)
            return points * 0.50;
        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile(
            "^(MCQ|TF|ESSAY)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)\\s*$");

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            while (line != null && line.trim().isEmpty())
                line = br.readLine();

            Matcher m = pattern.matcher(line.trim());
            m.matches();

            String type = m.group(1);
            String correct = m.group(3);
            String answer = m.group(4);
            double points = Double.parseDouble(m.group(5));

            Question q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(correct, answer, points);
                    break;
                case "TF":
                    q = new TF(correct, answer, points);
                    break;
                default:
                    q = new Essay(correct, answer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}