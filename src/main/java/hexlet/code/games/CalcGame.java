package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public final class CalcGame implements Game {

    private static final int MAX_A_VALUE = 10;
    private static final int MAX_B_VALUE = 10;

    private final Random random = new Random();
    private final char[] operations = {'+', '-', '*'};

    @Override
    public String getInstruction() {
        return "What is the result of the expression?";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var a = random.nextInt(MAX_A_VALUE) + 1;
        var b = random.nextInt(MAX_B_VALUE) + 1;
        var operation = operations[random.nextInt(operations.length)];

        var answer = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        };

        return new GameRoundDataDto(
            String.format("%s %s %s", a, operation, b),
            String.valueOf(answer)
        );
    }
}
