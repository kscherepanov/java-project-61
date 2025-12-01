package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;
import java.util.Random;

public final class ProgressionGame implements Game {

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    private static final int MIN_START = 1;
    private static final int MAX_START = 50;

    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 5;

    private final Random random = new Random();

    @Override
    public String getInstruction() {
        return "What number is missing in the progression?";
    }

    @Override
    public GameRoundDataDto generateRound() {
        var length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        var start = random.nextInt(MAX_START - MIN_START + 1) + MIN_START;
        var step = random.nextInt(MAX_STEP - MIN_STEP + 1) + MIN_STEP;
        var hiddenIndex = random.nextInt(length);

        var progression = new String[length];
        var answer = 0;

        for (var i = 0; i < length; i++) {
            var value = start + i * step;
            if (i == hiddenIndex) {
                progression[i] = "..";
                answer = value;
            } else {
                progression[i] = String.valueOf(value);
            }
        }

        var question = String.join(" ", progression);

        return new GameRoundDataDto(
            question,
            String.valueOf(answer)
        );
    }
}
