package week8;

import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 15 + weight + 0.2 * distance;
    }
}

class International extends Delivery {
    double customsFee;

    International(double w, double d, double c) {
        super(w, d);
        customsFee = c;
    }

    double calculateFee() {
        return 25 + 2 * weight + 0.5 * distance
               + customsFee;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new Standard(w, d);
                    break;
                case "EXPRESS":
                    delivery = new Express(w, d);
                    break;
                default:
                    double c = sc.nextDouble();
                    delivery = new International(w, d, c);
            }

            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
