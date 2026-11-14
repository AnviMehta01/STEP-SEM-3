
import java.util.*;

class Student {
    private String name;
    private int a, b, c;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 ||
            c < 0 || c > 100)
            return false;

        this.a = a;
        this.b = b;
        this.c = c;
        return true;
    }

    int getTotal() {
        return a + b + c;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getGrade() {
        double avg = getAverage();

        if (avg >= 80) return "A";
        if (avg >= 70) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    public String toString() {
        return name + " total=" + getTotal() +
                " avg=" + String.format(Locale.US, "%.2f", getAverage()) +
                " grade=" + getGrade();
    }
}

public class ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] s = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student st = new Student(name);

            if (st.setMarks(a, b, c))
                s[count++] = st;
            else
                System.out.println(name + " skipped: marks must be 0 to 100");
        }

        int passes = 0;

        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < count - i - 1; j++) {
                if (s[j].getTotal() < s[j + 1].getTotal()) {
                    Student temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    swapped = true;
                }
            }

            passes++;

            if (!swapped)
                break;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + s[i]);
        }

        System.out.println("Sorted in " + passes + " passes");
    }
}
