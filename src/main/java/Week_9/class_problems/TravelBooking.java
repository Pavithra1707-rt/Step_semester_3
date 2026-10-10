package Week_9.class_problems;

import java.util.Scanner;

abstract class Booking {
    double distance;


    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + 50;
    }


}

class BusBooking extends Booking {
    BusBooking(double distance) {
        super(distance);
    }


    double calculateFare() {
        return distance * 2;
    }


}

class TrainBooking extends Booking {
    TrainBooking(double distance) {
        super(distance);
    }


    double calculateFare() {
        return distance * 1.5;
    }


}

class FlightBooking extends Booking {
    FlightBooking(double distance) {
        super(distance);
    }


    double calculateFare() {
        return 2500 + distance * 4;
    }


}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalAmount = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            Booking booking;

            if (type.equals("BUS")) {
                booking = new BusBooking(distance);
            } else if (type.equals("TRAIN")) {
                booking = new TrainBooking(distance);
            } else {
                booking = new FlightBooking(distance);
            }

            double amount = booking.calculateTotal();
            totalAmount += amount;

            System.out.printf("%s: %.2f%n", type, amount);
        }

        System.out.printf("Total Amount: %.2f%n", totalAmount);

        sc.close();
    }


}
