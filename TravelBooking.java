package week9;

import java.util.Scanner;

abstract class Booking {
    double distance;
    static final double FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking b;

            if (mode.equals("BUS")) {
                b = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                b = new Train(distance);
            } else {
                b = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, b.total());
        }

        sc.close();
    }
}
