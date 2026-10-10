package Week_9.assignment_problems;

import java.util.Scanner;

abstract class Appliance {
    double hours;
    double watts;


    Appliance(double hours, double watts) {
        this.hours = hours;
        this.watts = watts;
    }

    double calculateUnits() {
        return watts * hours / 1000;
    }


}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours, 150);
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours, 1500);
    }


    public double applySaver(double units) {
        return units * 0.75;
    }


}

class TV extends Appliance {
    TV(double hours) {
        super(hours, 100);
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours, 500);
    }


    public double applySaver(double units) {
        return units * 0.75;
    }


}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.next();

                if (next.equalsIgnoreCase("SAVER")) {
                    saver = true;
                } else {
                    System.out.println("Invalid input");
                    return;
                }
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    System.out.println("Invalid appliance");
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = units * 8;
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }


}
