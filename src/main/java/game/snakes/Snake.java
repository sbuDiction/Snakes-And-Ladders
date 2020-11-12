package game.snakes;

import game.game_utilities.Colors;
import game.snakes_interface.Entity;

public class Snake implements Entity {
    private int mouthPosition;
    private int tailPosition;

    public Snake(int mouthPosition, int tailPosition) {
        this.mouthPosition = mouthPosition;
        this.tailPosition = tailPosition;
    }

    public int getMouthPosition() {
        return mouthPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }

    public String toString() {
        return Colors.RED_BOLD + "S" + Colors.RESET;
    }
}
