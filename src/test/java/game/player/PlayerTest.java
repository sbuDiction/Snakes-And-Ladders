package game.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    private final Player player = new Player();

    @Test
    void shouldRandomNUmbererBetweenOnendSix() {
        int diceRoll = player.rollDice();
        assertTrue(diceRoll <= 6 && diceRoll >= 1 );
    }
}
