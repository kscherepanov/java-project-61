package hexlet.code.games;

import hexlet.code.dto.GameRoundDataDto;

public interface Game {

    String getInstruction();

    GameRoundDataDto generateRound();
}
