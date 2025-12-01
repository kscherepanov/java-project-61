package hexlet.code;

import hexlet.code.games.Game;
import java.util.Scanner;

public class Engine {

    private static final int ROUNDS_COUNT = 3;

    public static void run(Scanner scanner, Game game) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        var userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        System.out.println(game.getInstruction());

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            var gameRoundData = game.generateRound();

            System.out.println("Question: " + gameRoundData.question());
            System.out.print("Your answer: ");

            var userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals(gameRoundData.answer())) {
                System.out.println("Correct!");
            } else {
                System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                    userInput,
                    gameRoundData.answer()
                );
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }

        System.out.printf("Congratulations, %s!\n", userName);
    }
}
