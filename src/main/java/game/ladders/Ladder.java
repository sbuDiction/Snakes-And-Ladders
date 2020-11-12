package game.ladders;

import game.game_utilities.Colors;
import game.snakes_interface.Entity;

public class Ladder implements Entity {
    private int foot = 4;
    private int head = 14;

    public Ladder(int foot, int head) {
        this.foot = foot;
        this.head = head;
    }

    public int getFoot() {
        return foot;
    }

    public int getHead() {
        return head;
    }

    public void setFoot(int foot) {
        this.foot = foot;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String toString() {
        return Colors.BLUE_BOLD + "L" + Colors.RESET;
    }
}
