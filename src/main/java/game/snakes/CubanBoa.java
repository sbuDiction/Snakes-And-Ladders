package game.snakes;

import game.Entity;

public class CubanBoa implements Entity {
    private int mouthPosition = 62;
    private int tailPosition = 18;

    public int getMouthPosition() {
        return mouthPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }
}
