package Week_9.assignment_problems;

import java.util.Scanner;

abstract class Parcel {
    double weight, declaredValue;


    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateShipping();

    double calculateInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateShipping() + calculateInsurance();
    }


}

interface Insurable {
    double calculateInsurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }


    double calculateShipping() {
        return 40 + 10 * weight;
    }


}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }


    double calculateShipping() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }


}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }


    double calculateShipping() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }


}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, value);
            } else {
                parcel = new FragileParcel(weight, value);
            }

            double shipping = parcel.calculateShipping();
            double insurance = parcel.calculateInsurance();
            double total = shipping + insurance;

            grandTotal += total;

            System.out.printf("%s: %.2f %.2f %.2f%n",
                    type, shipping, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }


}
