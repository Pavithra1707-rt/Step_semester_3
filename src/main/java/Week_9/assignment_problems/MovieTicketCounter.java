package Week_9.assignment_problems;

import java.util.Scanner;

abstract class Ticket {
    int count;


    Ticket(int count) {
        this.count = count;
    }

    abstract double calculatePrice();

    double calculateTotal() {
        return calculatePrice() + 20 * count;
    }


}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }


    double calculatePrice() {
        return 150 * count;
    }


}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }


    double calculatePrice() {
        return 250 * count;
    }


}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double calculatePrice() {
        return 400 * count;
    }


}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int count = sc.nextInt();

            Ticket ticket;

            if (type.equals("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (type.equals("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }

            double amount = ticket.calculateTotal();
            grandTotal += amount;

            System.out.printf("%s: %.2f%n", type, amount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }


}
