package Week_9.assignment_problems;

import java.util.Scanner;

abstract class Student {
    String name;
    double tuitionFee;


    Student(String name, double tuitionFee) {
        this.name = name;
        this.tuitionFee = tuitionFee;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return true;
    }


}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name, 40000);
    }


    double calculateFee() {
        return tuitionFee + 12000;
    }


}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name, 40000);
    }


    double calculateFee() {
        return tuitionFee + 60000;
    }

    boolean usesBus() {
        return false;
    }


}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name, 20000);
    }


    double calculateFee() {
        return tuitionFee + 12000;
    }


}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.calculateFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", student.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }


}
