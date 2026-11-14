package week11assignment;


import java.util.*;

public class PrizeTable {

    static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max])
                    max = j;
            }

            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks = {45, 90, 60, 75};

        int swaps = prizeTable(marks);

        System.out.println(Arrays.toString(marks));
        System.out.println("swaps = " + swaps);

        int[] marks2 = {80, 70, 60};

        swaps = prizeTable(marks2);

        System.out.println(Arrays.toString(marks2));
        System.out.println("swaps = " + swaps);
    }
}

