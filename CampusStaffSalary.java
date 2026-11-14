
import java.util.*;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    double getTotal() {
        return baseSalary + getBonus();
    }

    String getType() {
        return "Staff";
    }
}

class Teacher extends Staff {
    Teacher(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] s = new Staff[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher"))
                s[i] = new Teacher(name, salary);
            else if (type.equals("LabAssistant"))
                s[i] = new LabAssistant(name, salary);
            else
                s[i] = new Staff(name, salary);
        }

        for (int i = 0; i < n; i++) {
            double bonus = s[i].getBonus();
            double total = s[i].getTotal();

            System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                    s[i].name, s[i].getType(),
                    s[i].baseSalary, bonus, total);

            grandTotal += total;
        }

        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }
}
