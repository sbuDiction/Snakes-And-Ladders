package game.snakes;

import game.Entity;

public class EgyptianCobra implements Entity {
    private int mouthPosition = 64;
    private int tailPosition = 60;

    public int getMouthPosition() {
        return mouthPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }
}
