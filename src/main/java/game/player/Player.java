package game.player;


import game.game_utilities.Colors;
import game.snakes_interface.Entity;

public class Player implements Entity {
    private int position = 0;
    private int totalTracker;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int rollDice() {
        return ((int) (Math.random() * (6 - 1 + 1) + 1));
    }

    public String toString() {
        return Colors.RED_BACKGROUND_BRIGHT + "P1" + Colors.RESET;
    }

    public int rollDice(int dice) {
        return dice;
    }
}
