package game;

import game.ladders.*;
import game.player.Player;
import game.snakes.Snake;

public class App {
    Entity[] board = new Entity[101];

    public App(){
        for (int i  = 0; i<board.length - 1; i++)
            board[i] = new Tile(i);

        board[2] = new Ladder(2, 38);
        board[4] = new Ladder(4, 14);
        board[9] = new Ladder(9, 31);
        board[28] = new Ladder(28, 84);
        board[21] = new Ladder(21, 42);
        board[51] = new Ladder(51, 97);
        board[80] = new Ladder(80, 99);
        board[72] = new Ladder(72, 91);
    }

    public  Entity[] getBoard(){
        return board;
    }

    public void movePlayer(Player player, int numberOfMoves){
        int currentPlayerPosition = player.getPosition();

        player.setPosition(player.getPosition() + numberOfMoves);

        board[currentPlayerPosition] = new Tile(currentPlayerPosition);

        int newPlayerPosition = player.getPosition();
        board[newPlayerPosition] = player;
    }

    public void movePlayerDownSnake(Player player, Entity entity){
        if (entity instanceof Snake){
            player.setPosition(((Snake)(entity)).getTail());
            board[((Snake)(entity)).getTail()] = player;
        }
    }

    public void movePlayerUpLadder(Player player, Entity entity){
        if (entity instanceof Ladder){
            player.setPosition(((Ladder)(entity)).getHead());
            board[((Ladder)(entity)).getHead()] = player;
        }
    }

    public void displayBoard(){
        for(int i = 1; i < board.length - 1; i++)
            System.out.println(board[i]);
    }

    public static void main(String[] args) {
        App app = new App();
        Player player = new Player();

        app.movePlayerUpLadder(player, app.getBoard()[28]);

        app.displayBoard();
    }

}
