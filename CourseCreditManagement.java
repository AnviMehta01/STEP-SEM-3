package week6;

import java.util.Scanner;

public class CourseCreditManagement {

    static class Course {

        String code;
        String title;
        int credits;
        int labCredits;

        public Course(String code, String title,
                      int credits, int labCredits) {

            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public Course(String code, String title, int credits) {

            this(code, title, credits, 0);
        }

        int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course code: ");
        String code1 = sc.nextLine();

        System.out.print("Enter course title: ");
        String title1 = sc.nextLine();

        System.out.print("Enter credits: ");
        int credits1 = sc.nextInt();

        sc.nextLine();

        Course course1 =
                new Course(code1, title1, credits1);

        System.out.print("Enter second course code: ");
        String code2 = sc.nextLine();

        System.out.print("Enter second course title: ");
        String title2 = sc.nextLine();

        System.out.print("Enter credits: ");
        int credits2 = sc.nextInt();

        System.out.print("Enter lab credits: ");
        int labCredits2 = sc.nextInt();

        Course course2 =
                new Course(code2, title2, credits2, labCredits2);

        System.out.println(course1.code
                + " total credits: "
                + course1.totalCredits());

        System.out.println(course2.code
                + " total credits: "
                + course2.totalCredits());
    }
}