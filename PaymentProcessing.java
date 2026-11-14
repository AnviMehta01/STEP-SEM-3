
import java.util.*;

interface PaymentMode {
    double processPayment(double amount);
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount * 1.02;
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        String[] modes = new String[n];
        double[] amounts = new double[n];

        double total = 0;

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            amounts[i] = sc.nextDouble();

            switch (modes[i]) {
                case "Cash":
                    payments[i] = new CashPayment();
                    break;

                case "Card":
                    payments[i] = new CardPayment();
                    break;

                case "UPI":
                    payments[i] = new UpiPayment();
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            double processed = payments[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];

            System.out.printf(Locale.US,
                    "%s: amount %.1f, fee %.1f, processed %.1f%n",
                    modes[i], amounts[i], fee, processed);

            total += processed;
        }

        System.out.printf(Locale.US,
                "Total Amount Processed: %.1f%n", total);
    }
}
