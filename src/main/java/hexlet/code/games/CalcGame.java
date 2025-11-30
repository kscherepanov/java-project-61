package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public class CalcGame implements Game {

    protected final Random random = new Random();
    private final char[] operations = {'+', '-', '*'};

    @Override
    public String getInstruction() {
        return "What is the result of the expression?";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var a = random.nextInt(10) + 1;
        var b = random.nextInt(10) + 1;
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