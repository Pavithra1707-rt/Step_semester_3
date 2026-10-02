package Week_8.assignment_problems;

import java.util.Scanner;

class Electricity {
    double units;

    Electricity(double units) {
        this.units = units;
    }

    double calculateBill() {
        return 0;
    }
}

class SingleRoom extends Electricity {

    SingleRoom(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Electricity {
    int occupants;

    SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6) / occupants;
    }
}

class ACRoom extends Electricity {

    ACRoom(double units) {
        super(units);
    }

    double calculateBill() {
        return (units * 10) + 200;
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Electricity room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            }
            else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            }
            else {
                room = new ACRoom(units);
            }

            double bill = room.calculateBill();

            System.out.println(bill);
            total += bill;
        }

        System.out.println("Total: " + total);

        sc.close();
    }
}