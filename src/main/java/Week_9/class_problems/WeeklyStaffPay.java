package Week_9.class_problems;

import java.util.Scanner;

abstract class Staff {
    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double salary;


    FullTimeStaff(double salary) {
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }


}

class HourlyStaff extends Staff {
    double hours, rate;


    HourlyStaff(double hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }


}

class InternStaff extends Staff {
    double stipend;


    InternStaff(double stipend) {
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }


}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalPay = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Staff staff;

            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staff = new FullTimeStaff(salary);
            } else if (type.equals("HOURLY")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staff = new HourlyStaff(hours, rate);
            } else {
                double stipend = sc.nextDouble();
                staff = new InternStaff(stipend);
            }

            double pay = staff.calculatePay();
            totalPay += pay;

            System.out.printf("%s: %.2f%n", name, pay);
        }

        System.out.printf("Total Pay: %.2f%n", totalPay);

        sc.close();
    }


}
