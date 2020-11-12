package game.player;

import game.App;
import game.ladders.Ladder;
import game.snakes.Snake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakesAndLaddersTest {
    @Test
    public void snakeShouldEatPlayerAndSetPlayerToTailPosition() {
        try {
            App app = new App();
            Player player1 = new Player();
            Snake blackMamba = new Snake(17, 7);

            app.movePlayerDownSnake(player1, blackMamba);

            assertEquals(player1.getPosition(), 7);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ladderShouldMovePlayerAndSetPlayerToLadderPosision() {
        try {
            App app = new App();
            Player player1 = new Player();
            Ladder stepLadder = new Ladder(2, 38);
            app.movePlayerUpLadder(player1, stepLadder);

            assertEquals(player1.getPosition(), 38);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
