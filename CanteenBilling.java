package week8assignment;

import java.util.*;

abstract class Bill {
    double amount;

    Bill(double amount) {
        this.amount = amount;
    }

    abstract double calculate();
}

class StudentBill extends Bill {
    StudentBill(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 0.90;
    }
}

class StaffBill extends Bill {
    StaffBill(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 0.95;
    }
}

class GuestBill extends Bill {
    GuestBill(double amount) {
        super(amount);
    }

    double calculate() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Bill b;

            switch (type) {
                case "STUDENT":
                    b = new StudentBill(amount);
                    break;
                case "STAFF":
                    b = new StaffBill(amount);
                    break;
                default:
                    b = new GuestBill(amount);
            }

            double result = b.calculate();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
