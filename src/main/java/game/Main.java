package game;

import game.ladders.Ladders;
import game.players.Player;
import game.snakes.*;


public class Main {
    Entity[] snakesAndLaddersBord = new Entity[101];

    public static void main(String[] args) {
        Main snakesAndLaddersGame = new Main();
//        snakesAndLaddersGame.buildBord();

        Player player1 = new Player();
        System.out.println(snakesAndLaddersGame.checkForSnakesAndLadders(17));

    }

    public boolean checkForSnakesAndLadders(int positionNumber) {
        System.out.println(((Snake) snakesAndLaddersBord[1]).getTailPosition());
        return snakesAndLaddersBord[positionNumber] instanceof Snake || snakesAndLaddersBord[positionNumber] instanceof Ladders;
    }



}
