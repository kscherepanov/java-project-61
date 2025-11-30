package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public final class PrimeGame implements Game {

    private final Random random = new Random();

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    @Override
    public String getInstruction() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        var answer = isPrime(number) ? "yes" : "no";
        return new GameRoundDataDto(
            String.valueOf(number),
            answer
        );
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
