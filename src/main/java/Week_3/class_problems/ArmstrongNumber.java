package Week_3.class_problems;



import java.util.Scanner;

public class ArmstrongNumber {

    static void checkArmstrong(int number) {

        int original = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum = sum + digit * digit * digit;
            number = number / 10;
        }

        if (sum == original) {
            System.out.println("Is the number " + original + " an Armstrong number? Yes");
        } else {
            System.out.println("Is the number " + original + " an Armstrong number? No");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        checkArmstrong(number);

        sc.close();
    }
}
