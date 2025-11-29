package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    private static final int ROUNDS_COUNT = 3;

    private final Random random = new Random();

    private final Scanner scanner;
    private final String userName;

    public EvenGame(
        Scanner scanner,
        String userName
    ) {
        this.scanner = scanner;
        this.userName = userName;
    }

    public void run() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            var number = random.nextInt(100) + 1;

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            var userAnswer = scanner.nextLine().trim().toLowerCase();
            var correctAnswer = getCorrectAnswer(number);

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                    userAnswer,
                    correctAnswer
                );
                System.out.printf("Let's try again, %s!", userName);

                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    private String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
