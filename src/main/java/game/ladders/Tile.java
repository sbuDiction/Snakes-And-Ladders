package game.ladders;

import game.Entity;

public class Tile implements Entity {

    private int tilePos;

    public Tile(int tilePos){
        this.tilePos = tilePos;
    }

    public String toString(){
        return "" + tilePos;
    }
}
