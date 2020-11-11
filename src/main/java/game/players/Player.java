package game.players;

import game.Entity;

public class Player implements Entity {
    private int playerPosition = 0;

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public int rollDice() {
        return (int) (Math.random() * (7 - 1 + 1) + 1);
    }
}
