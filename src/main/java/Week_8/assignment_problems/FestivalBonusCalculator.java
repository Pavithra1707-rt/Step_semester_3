package Week_8.assignment_problems;

import java.util.Scanner;

class Employee {
    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    double calculateBonus() {
        return 0;
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(double salary) {
        super(salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(double salary) {
        super(salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {

    Intern(double salary) {
        super(salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTimeEmployee(salary);
            }
            else if (type.equals("PARTTIME")) {
                employee = new PartTimeEmployee(salary);
            }
            else {
                employee = new Intern(salary);
            }

            double bonus = employee.calculateBonus();

            System.out.println(bonus);
            total += bonus;
        }

        System.out.println("Total: " + total);

        sc.close();
    }
}