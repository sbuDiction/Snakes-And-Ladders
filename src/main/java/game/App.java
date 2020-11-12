package game;

import game.game_utilities.Colors;
import game.ladders.*;
import game.player.Player;
import game.snakes.Snake;
import game.snakes_interface.Entity;

public class App {
    Entity[] board = new Entity[102];

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
                System.out.println(Colors.RED + "The snake got you!!" + Colors.RESET + "\n");
                //updatePlayerPositionOnBord(player, positionPlayerGoing, currentPlayerPosition);
            }
            if (board[positionPlayerGoing] instanceof Ladder) {
                movePlayerUpLadder(player, board[positionPlayerGoing]);
                System.out.println(Colors.GREEN + "Yey!! You found a Ladder : " + Colors.RESET + "\n");
                //updatePlayerPositionOnBord(player, positionPlayerGoing, currentPlayerPosition);
            }
        } else {
            updatePlayerPositionOnBord(player, positionPlayerGoing, currentPlayerPosition);
        }
    }

    public void updatePlayerPositionOnBord(Player player, int newPosition, int currentPosition) {
        player.setPosition(newPosition);

        board[currentPosition] = new Tile(currentPosition);

        board[newPosition] = player;
    }

    public void movePlayerDownSnake(Player player, Entity entity) {
        if (entity instanceof Snake) {
            Snake snake = ((Snake) (entity));

            int pos = player.getPosition();

            player.setPosition(snake.getTailPosition());
            board[snake.getTailPosition()] = player;
            board[snake.getMouthPosition()] = snake;
        }
    }

    public void movePlayerUpLadder(Player player, Entity entity) {
        if (entity instanceof Ladder) {
            Ladder ladder = ((Ladder) (entity));

            player.setPosition(ladder.getHead());
            board[ladder.getHead()] = player;
            board[ladder.getFoot()] = ladder;
        }
    }

    public void displayBoard() {
        String gameBoard = "";

        for (int i = 1; i < board.length - 1; i++) {
            if (i % 10 == 0) {
                gameBoard += " \t" + board[i];
                gameBoard += "\n";
            } else {
                gameBoard += " \t" + board[i];
            }
        }
        System.out.println(gameBoard);
    }

    public boolean checkForSnakesAndLadders(int positionNumber) {
        return board[positionNumber] instanceof Snake || board[positionNumber] instanceof Ladder;
    }

}
