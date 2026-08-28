package Week_1.assignment_problems;



import java.util.Scanner;

public class WordLengthProfiler {

    static void analyzeWords(String text) {

        String[] words = text.split("\\s+");

        int totalLength = 0;
        String shortest = words[0];
        String longest = words[0];

        for (int i = 0; i < words.length; i++) {

            String word = words[i].replaceAll("[^a-zA-Z]", "");

            totalLength += word.length();

            if (word.length() < shortest.length()) {
                shortest = word;
            }

            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        double average = (double) totalLength / words.length;

        System.out.printf("Average Word Length: %.2f%n", average);
        System.out.println("Shortest Word: " + shortest +
                " (" + shortest.length() + ")");
        System.out.println("Longest Word: " + longest +
                " (" + longest.length() + ")");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String text = sc.nextLine();

        analyzeWords(text);

        sc.close();
    }
}