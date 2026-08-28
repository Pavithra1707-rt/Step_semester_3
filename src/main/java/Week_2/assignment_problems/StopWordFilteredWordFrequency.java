package Week_2.assignment_problems;



import java.util.Scanner;

public class StopWordFilteredWordFrequency {

    static void wordFrequency(String text, String stopWords) {

        String[] words = text.toLowerCase().split(" ");
        String[] stop = stopWords.toLowerCase().split(",");

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (word.length() == 0) {
                continue;
            }

            boolean isStopWord = false;

            for (int j = 0; j < stop.length; j++) {
                if (word.equals(stop[j].trim())) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                int count = 0;

                for (int j = 0; j < words.length; j++) {
                    if (word.equals(words[j])) {
                        count++;
                    }
                }

                boolean alreadyPrinted = false;

                for (int j = 0; j < i; j++) {
                    if (word.equals(words[j])) {
                        alreadyPrinted = true;
                        break;
                    }
                }

                if (!alreadyPrinted) {
                    System.out.println(word + " : " + count);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter stop words separated by comma: ");
        String stopWords = sc.nextLine();

        wordFrequency(text, stopWords);
    }
}
