package week10;


import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;

        for (int mark : marks)
            sum += mark;

        return sum / 3.0;
    }

    char grade() {
        double avg = average();

        if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'C';
        else if (avg >= 40)
            return 'D';
        else
            return 'F';
    }

    void display() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average(), grade());
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        int[] marks = new int[3];

        for (int i = 0; i < 3; i++)
            marks[i] = sc.nextInt();

        Student s = new Student(name, marks);
        s.display();

        sc.close();
    }
}

