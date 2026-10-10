package Week_9.assignment_problems;

import java.util.Scanner;

abstract class Cab {
    double distance;


    Cab(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double getBaseFare(double rate) {
        return Math.max(distance * rate, 100);
    }


}

interface NightService {
    double calculateNightFare(double fare);
}

class MiniCab extends Cab {
    MiniCab(double distance) {
        super(distance);
    }


    double calculateFare() {
        return getBaseFare(10);
    }


}

class SedanCab extends Cab implements NightService {
    SedanCab(double distance) {
        super(distance);
    }


    double calculateFare() {
        return getBaseFare(14);
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }


}

class SUVCab extends Cab implements NightService {
    SUVCab(double distance) {
        super(distance);
    }


    double calculateFare() {
        return getBaseFare(18);
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }

}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalFare = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new MiniCab(distance);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(distance);
            } else {
                cab = new SUVCab(distance);
            }

            if (time.equals("NIGHT") && cab instanceof MiniCab) {
                System.out.println("MINI: night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).calculateNightFare(fare);
                }
            }

            totalFare += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total Fare: %.2f%n", totalFare);

        sc.close();
    }


}
