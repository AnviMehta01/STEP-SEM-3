
import java.util.*;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];

        double total = 0;
        int dryDays = 0;
        int wettestDay = 0;

        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();

            total += rainfall[i];

            if (rainfall[i] == 0)
                dryDays++;

            if (rainfall[i] > rainfall[wettestDay])
                wettestDay = i;
        }

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.printf(Locale.US, "%.1f ", rainfall[i]);
        }

        System.out.println();

        System.out.printf(Locale.US,
                "Total Rainfall: %.1f mm%n", total);

        System.out.printf(Locale.US,
                "Average Rainfall: %.2f mm%n", total / 7);

        System.out.printf(Locale.US,
                "Wettest Day: Day %d (%.1f mm)%n",
                wettestDay + 1, rainfall[wettestDay]);

        System.out.println("Total Dry Days: " + dryDays);
    }
}
