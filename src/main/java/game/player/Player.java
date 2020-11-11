package game.player;


import game.Entity;

public class Player implements Entity {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int rollDice(){
        return (int)(Math.random() * (7 - 1 + 1) + 1);
    }

    public String toString(){
        return "Player";
    }
}
