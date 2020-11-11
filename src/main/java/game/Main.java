package game;

import game.ladders.Ladders;
import game.players.Player;
import game.snakes.*;


public class Main {
    Entity[] snakesAndLaddersBord = new Entity[101];

    public static void main(String[] args) {
        Main snakesAndLaddersGame = new Main();
        snakesAndLaddersGame.buildBord();

        Player player1 = new Player();
        System.out.println(snakesAndLaddersGame.checkForSnakesAndLadders(17));

    }

    public boolean checkForSnakesAndLadders(int positionNumber) {
        System.out.println(((Snake) snakesAndLaddersBord[1]).getTailPosition());
        return snakesAndLaddersBord[positionNumber] instanceof Snake || snakesAndLaddersBord[positionNumber] instanceof Ladders;
    }

    public void buildBord() {
        snakesAndLaddersBord[17] = new Snake(17, 7);
        snakesAndLaddersBord[54] = new Snake(54, 34);
        snakesAndLaddersBord[62] = new Snake(62, 18);
        snakesAndLaddersBord[64] = new Snake(64, 60);
        snakesAndLaddersBord[87] = new Snake(87, 36);
        snakesAndLaddersBord[93] = new Snake(93, 73);
        snakesAndLaddersBord[95] = new Snake(95, 75);
        snakesAndLaddersBord[98] = new Snake(98, 79);
    }

}
