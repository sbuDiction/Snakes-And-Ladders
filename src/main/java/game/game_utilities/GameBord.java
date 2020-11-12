package game.game_utilities;

import game.App;
import game.game_utilities.Colors;
import game.player.Player;

import java.util.Scanner;

public class GameBord {

    public static void main(String[] args) {
        App app = new App();
        Player player1 = new Player();
        Scanner scanner = new Scanner(System.in);
        app.buildBord();
        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT + "Welcome to Snakes and Ladders" + Colors.RESET);
        OUTER:
        while (true) {
            System.out.println(Colors.BLACK_BACKGROUND_BRIGHT + "Do you want to roll?" + Colors.RESET);
            System.out.println(Colors.BLUE + "roll " + Colors.RESET + Colors.RED + "or" + " exit" + Colors.RESET);
            String strInput = scanner.nextLine();
            if (strInput.equals("roll")) {
                int diceRoll = player1.rollDice();
                START:
                while (true) {
                    if (diceRoll == 6) {
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT + "Do you want to roll?" + Colors.RESET);
                        System.out.println(Colors.BLUE + "roll " + Colors.RESET + Colors.RED + "or" + " exit" + Colors.RESET);
                        MAINGAME:
                        while (true) {
                            if (strInput.equals("roll")) {
                                System.out.println("\nDo you want to roll?\nroll/exit");
                                strInput = scanner.nextLine();
                                int newDiceRoll = player1.rollDice();
                                int curentPlayerPosition = player1.getPosition();
                                app.movePlayer(player1, newDiceRoll);

                                if(player1.getPosition() >= 100){
                                    System.out.print("Hooray you won!!!!!");
                                    System.exit(0);
                                }

                                System.out.println("Player moved from: " + curentPlayerPosition + " to: " + player1.getPosition());
                                app.displayBoard();
                            } else if (strInput.equals("exit")) {
                                System.out.println("Thank You for playing");
                                System.exit(0);

                            }
                        }
                    } else {
                        System.out.println("You didn't roll a six: " + diceRoll);
                        continue OUTER;
                    }
                }

            }
        }
    }
}
