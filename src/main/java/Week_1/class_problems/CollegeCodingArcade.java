package Week_1.class_problems;
import java.util.Scanner;
import java.util.Random;

public class CollegeCodingArcade {



        static String playRound(String player, String computer) {

            if (player.equals(computer)) {
                return "Draw";
            }

            if ((player.equals("Rock") && computer.equals("Scissors")) ||
                    (player.equals("Paper") && computer.equals("Rock")) ||
                    (player.equals("Scissors") && computer.equals("Paper"))) {
                return "Player Wins";
            }

            return "Computer Wins";
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            String[] moves = {"Rock", "Paper", "Scissors"};

            int wins = 0;
            int losses = 0;
            int draws = 0;

            System.out.println("Rock Paper Scissors Game");

            for (int i = 1; i <= 5; i++) {

                System.out.print("Enter your move (Rock/Paper/Scissors): ");
                String player = sc.next();

                String computer = moves[random.nextInt(3)];

                String result = playRound(player, computer);

                System.out.println("Computer: " + computer);
                System.out.println("Result: " + result);
                System.out.println();

                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }
            }

            double percentage = (wins / 5.0) * 100;

            System.out.println("Final Summary");
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.println("Draws: " + draws);
            System.out.println("Win Percentage: " + percentage + "%");

            sc.close();
        }
    }

