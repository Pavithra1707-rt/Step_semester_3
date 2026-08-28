package Week_3.class_problems;

import java.util.Scanner;

public class PrimeNumber {

    static void checkPrime(int number) {

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Is the number " + number + " a Prime number? Yes");
        } else {
            System.out.println("Is the number " + number + " a Prime number? No");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        checkPrime(number);

        sc.close();
    }
}