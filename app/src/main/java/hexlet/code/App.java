package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static final int GREAT_MENU_INDEX = 1;
    private static final int EVEN_GAME_MENU_INDEX = 2;
    private static final int CALC_GAME_MENU_INDEX = 3;
    private static final int GCD_GAME_MENU_INDEX = 4;
    private static final int PROGRESSION_GAME_MENU_INDEX = 5;
    private static final int PRIME_GAME_MENU_INDEX = 6;

    private static final Map<Integer, String> MENU_ITEMS = new LinkedHashMap<>();

    static {
        MENU_ITEMS.put(GREAT_MENU_INDEX, "Greet");
        MENU_ITEMS.put(EVEN_GAME_MENU_INDEX, "Even");
        MENU_ITEMS.put(CALC_GAME_MENU_INDEX, "Calc");
        MENU_ITEMS.put(GCD_GAME_MENU_INDEX, "GCD");
        MENU_ITEMS.put(PROGRESSION_GAME_MENU_INDEX, "Progression");
        MENU_ITEMS.put(PRIME_GAME_MENU_INDEX, "Prime");
        MENU_ITEMS.put(0, "Exit");
    }

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        MENU_ITEMS.forEach((menuIndex, menuItemName) -> {
            System.out.printf("%s - %s\n", menuIndex, menuItemName);
        });

        var scanner = new Scanner(System.in);

        System.out.print("Your choice: ");

        var menuChoice = Integer.parseInt(scanner.nextLine());

        switch (menuChoice) {
            case GREAT_MENU_INDEX -> Cli.run(scanner);
            case EVEN_GAME_MENU_INDEX -> Engine.run(scanner, new EvenGame());
            case CALC_GAME_MENU_INDEX -> Engine.run(scanner, new CalcGame());
            case GCD_GAME_MENU_INDEX -> Engine.run(scanner, new GCDGame());
            case PROGRESSION_GAME_MENU_INDEX -> Engine.run(scanner, new ProgressionGame());
            case PRIME_GAME_MENU_INDEX -> Engine.run(scanner, new PrimeGame());
            default -> {
            }
        }

        scanner.close();
    }
}
