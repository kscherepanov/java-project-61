package hexlet.code;

import hexlet.code.games.EvenGame;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Cli {

    private static final int EVEN_GAME_MENU_INDEX = 2;

    private static final Map<Integer, String> MENU_ITEMS = new LinkedHashMap<>();

    static {
        MENU_ITEMS.put(EVEN_GAME_MENU_INDEX, "Even");
        MENU_ITEMS.put(1, "Greet");
        MENU_ITEMS.put(0, "Exit");
    }

    public static void run() {
        System.out.println("Please enter the game number and press Enter.");
        MENU_ITEMS.forEach((menuIndex, menuItemName) -> {
            System.out.printf("%s - %s\n", menuIndex, menuItemName);
        });

        var scanner = new Scanner(System.in);

        System.out.print("Your choice: ");

        var menuChoice = Integer.parseInt(scanner.nextLine());

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        var userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        if (menuChoice == EVEN_GAME_MENU_INDEX) {
            new EvenGame(scanner, userName).run();
        }

        scanner.close();
    }
}
