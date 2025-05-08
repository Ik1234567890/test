import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MathAssessment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().toLowerCase(); // Use lowercase for file name
        String fileName = name + "-answers.txt";

        try (PrintWriter outStream = new PrintWriter(new FileOutputStream(fileName))) {
            outStream.println("Math Assessment Results for " + name + ":");

            for (int i = 1; i <= 5; i++) {
                int num1 = random.nextInt(100) + 1;
                int num2 = random.nextInt(100) + 1;
                char operator = random.nextBoolean() ? '+' : '-';

                int correctAnswer = (operator == '+') ? num1 + num2 : num1 - num2;

                System.out.print("Question " + i + ": " + num1 + " " + operator + " " + num2 + " = ");
                int userAnswer = scanner.nextInt();

                boolean isCorrect = (userAnswer == correctAnswer);

                outStream.println("Q" + i + ": " + num1 + " " + operator + " " + num2 +
                        " = " + userAnswer + " → " + (isCorrect ? "Correct" : "Incorrect (Correct: " + correctAnswer + ")"));
            }

            System.out.println("Results saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Oops! Something went wrong: " + e.getMessage());
        }

        scanner.close();
    }
}
