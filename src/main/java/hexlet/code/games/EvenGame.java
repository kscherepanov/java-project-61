package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public class EvenGame implements Game {

    protected final Random random = new Random();

    @Override
    public String getInstruction() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var question = random.nextInt(100) + 1;
        var answer = question % 2 == 0 ? "yes" : "no";

        return new GameRoundDataDto(
            String.valueOf(question),
            answer
        );
    }
}
