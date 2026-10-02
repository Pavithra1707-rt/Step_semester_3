package Week_8.assignment_problems;

import java.util.Scanner;

class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    double calculateBill() {
        return amount;
    }
}

class StudentCustomer extends Customer {

    StudentCustomer(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {

    StaffCustomer(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {

    GuestCustomer(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new StudentCustomer(amount);
            }
            else if (type.equals("STAFF")) {
                customer = new StaffCustomer(amount);
            }
            else {
                customer = new GuestCustomer(amount);
            }

            double bill = customer.calculateBill();

            System.out.println(bill);
            total += bill;
        }

        System.out.println("Total: " + total);

        sc.close();
    }
}