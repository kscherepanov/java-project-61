package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public class GCDGame implements Game {

    private final Random random = new Random();

    @Override
    public String getInstruction() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var a = random.nextInt(100) + 1;
        var b = random.nextInt(100) + 1;
        var answer = getGcd(a, b);

        return new GameRoundDataDto(
            String.format("%s %s", a, b),
            String.valueOf(answer)
        );
    }

    public int getGcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }

        return getGcd(b, a % b);
    }
}
