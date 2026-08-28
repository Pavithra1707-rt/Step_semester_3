package Week_3.class_problems;



import java.util.Scanner;

public class PalindromeNumber {

    static void checkPalindrome(int number) {

        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        if (reversed == original) {
            System.out.println("Is the number " + original + " a Palindrome? Yes");
        } else {
            System.out.println("Is the number " + original + " a Palindrome? No");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        checkPalindrome(number);

        sc.close();
    }
}