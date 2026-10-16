package week10assignment;

public class ClassAttendanceTracker {

    static void attendanceSummary(int[] days) {
        int present = 0, count = 0, longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                count++;

                if (count > longest)
                    longest = count;
            } else {
                count = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longest);
    }

    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(days);

        int[] days2 = {0, 0, 0};
        attendanceSummary(days2);
    }
}
