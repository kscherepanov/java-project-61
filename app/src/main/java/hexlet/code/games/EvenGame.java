package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public final class EvenGame implements Game {

    private static final int MAX_NUMBER = 10;
    private final Random random = new Random();

    @Override
    public String getInstruction() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var question = random.nextInt(MAX_NUMBER) + 1;
        var answer = question % 2 == 0 ? "yes" : "no";

        return new GameRoundDataDto(
            String.valueOf(question),
            answer
        );
    }
}
