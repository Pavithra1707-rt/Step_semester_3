package Week_3.class_problems;



import java.util.Scanner;

public class GCD {

    static int findGCD(int number1, int number2) {

        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        return number1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        int gcd = findGCD(number1, number2);

        System.out.println("The GCD of " + number1 +
                " and " + number2 + " is " + gcd);

        sc.close();
    }
}