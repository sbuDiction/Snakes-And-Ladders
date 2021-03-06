package game;

import game.ladders.*;
import game.player.Player;
import game.snakes.Snake;

public class App {
    Entity[] board = new Entity[101];

    public void buildBord() {
        for (int i = 0; i < board.length - 1; i++)
            board[i] = new Tile(i);
// Ladders
        board[2] = new Ladder(2, 38);
        board[4] = new Ladder(4, 14);
        board[9] = new Ladder(9, 31);
        board[28] = new Ladder(28, 84);
        board[21] = new Ladder(21, 42);
        board[51] = new Ladder(51, 97);
        board[80] = new Ladder(80, 99);
        board[72] = new Ladder(72, 91);

//        Snakes
        board[17] = new Snake(17, 7);
        board[54] = new Snake(54, 34);
        board[62] = new Snake(62, 18);
        board[64] = new Snake(64, 60);
        board[87] = new Snake(87, 36);
        board[93] = new Snake(93, 73);
        board[95] = new Snake(95, 75);
        board[98] = new Snake(98, 79);
//

    }

    public Entity[] getBoard() {
        return board;
    }

    public void movePlayer(Player player, int numberOfMoves) {
        int currentPlayerPosition = player.getPosition();
        int positionPlayerGoing = player.getPosition() + numberOfMoves;
        if (checkForSnakesAndLadders(positionPlayerGoing)) {
            if (board[positionPlayerGoing] instanceof Snake) {
                movePlayerDownSnake(player, board[positionPlayerGoing]);
                System.out.println("The snake got you!! at position:" +
                        board[positionPlayerGoing]
                        + "\nPlayer current position: "
                        + player.getPosition());
            }
            if (board[positionPlayerGoing] instanceof Ladder) {
                movePlayerUpLadder(player, board[positionPlayerGoing]);
                System.out.println("You found a Ladder Yey! at position0: " + positionPlayerGoing + "\n");

            }
        } else {
            player.setPosition(positionPlayerGoing);
            board[currentPlayerPosition] = new Tile(currentPlayerPosition);

            int newPlayerPosition = player.getPosition();
            board[newPlayerPosition] = player;
        }
    }

    public void movePlayerDownSnake(Player player, Entity entity) {
        if (entity instanceof Snake) {
            player.setPosition(((Snake) (entity)).getTailPosition());
            board[((Snake) (entity)).getTailPosition()] = player;
        }
    }

    public void movePlayerUpLadder(Player player, Entity entity) {
        if (entity instanceof Ladder) {
            player.setPosition(((Ladder) (entity)).getHead());
            board[((Ladder) (entity)).getHead()] = player;
        }
    }

    public void displayBoard() {
        for (int i = 1; i < board.length - 1; i++)
            System.out.println(board[i]);
    }

    public boolean checkForSnakesAndLadders(int positionNumber) {
        return board[positionNumber] instanceof Snake || board[positionNumber] instanceof Ladders;
    }

}
