package week9assignment;


import java.util.Scanner;

abstract class Appliance {
    abstract double power();

    double units(double hours) {
        return power() * hours / 1000;
    }
}

interface SaverMode {
    double savedUnits(double units);
}

class Fridge extends Appliance {
    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    double power() {
        return 1500;
    }

    public double savedUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    double power() {
        return 500;
    }

    public double savedUnits(double units) {
        return units * 0.75;
    }
}

class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            String option = sc.nextLine().trim();

            boolean saver = option.equals("SAVER");
            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge();
                    break;
                case "AC":
                    a = new AC();
                    break;
                case "TV":
                    a = new TV();
                    break;
                default:
                    a = new Washer();
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units(hours);

            if (saver) {
                units = ((SaverMode) a).savedUnits(units);
            }

            double cost = units * 8;
            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}

