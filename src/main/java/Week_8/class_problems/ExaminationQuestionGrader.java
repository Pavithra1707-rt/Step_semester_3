package Week_8.class_problems;

import java.util.Scanner;

class Question {
    String type;
    double points;
    String correctAnswer;

    Question(String type, double points, String correctAnswer) {
        this.type = type;
        this.points = points;
        this.correctAnswer = correctAnswer;
    }

    double grade(String studentAnswer) {
        return 0;
    }
}

class MCQQuestion extends Question {

    MCQQuestion(double points, String correctAnswer) {
        super("MCQ", points, correctAnswer);
    }

    double grade(String studentAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalseQuestion extends Question {

    TrueFalseQuestion(double points, String correctAnswer) {
        super("TF", points, correctAnswer);
    }

    double grade(String studentAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class EssayQuestion extends Question {

    EssayQuestion(double points, String correctAnswer) {
        super("ESSAY", points, correctAnswer);
    }

    double grade(String studentAnswer) {

        String[] keywords = correctAnswer.toLowerCase().split(",");

        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.nextLine();
            double points = Double.parseDouble(sc.nextLine());
            String correctAnswer = sc.nextLine();
            String studentAnswer = sc.nextLine();

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(points, correctAnswer);
            }
            else if (type.equals("TF")) {
                question = new TrueFalseQuestion(points, correctAnswer);
            }
            else {
                question = new EssayQuestion(points, correctAnswer);
            }

            double marks = question.grade(studentAnswer);

            System.out.println("Marks: " + marks);

            total += marks;
        }

        System.out.println("Total: " + total);

        sc.close();
    }
}