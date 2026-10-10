package Week_9.class_problems;

import java.util.Scanner;

abstract class ElectricityConnection {
    double units;


    ElectricityConnection(double units) {
        this.units = units;
    }

    abstract double calculateBill();


}

class HomeConnection extends ElectricityConnection {
    HomeConnection(double units) {
        super(units);
    }


    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return 100 * 5 + (units - 100) * 7;
        }
    }


}

class ShopConnection extends ElectricityConnection {
    ShopConnection(double units) {
        super(units);
    }


    double calculateBill() {
        return units * 8 + 100;
    }


}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(double units) {
        super(units);
    }


    double calculateBill() {
        return Math.max(units * 6, 1000);
    }


}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalBill = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();

            ElectricityConnection connection;

            if (type.equals("HOME")) {
                connection = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connection = new ShopConnection(units);
            } else {
                connection = new FactoryConnection(units);
            }

            double bill = connection.calculateBill();
            totalBill += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total Bill: %.2f%n", totalBill);

        sc.close();
    }


}
