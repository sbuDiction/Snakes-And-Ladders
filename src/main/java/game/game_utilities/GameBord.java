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
                System.out.println("PLayer roller: " + diceRoll);

                START:
                while (true) {
                    if (diceRoll == 6) {
                        player1.setPosition(1);

                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT + "Yaayyyy!! you rolled a six" + Colors.RESET);
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT + "Do you want to roll?" + Colors.RESET);
                        System.out.println(Colors.BLUE + "roll " + Colors.RESET + Colors.RED + "or" + " exit" + Colors.RESET);

                        MAINGAME:
                        while (true) {
                            if (strInput.equals("roll")) {
                                strInput = scanner.nextLine();

                                diceRoll = player1.rollDice();

                                int curentPlayerPosition = player1.getPosition();

                                if(curentPlayerPosition+diceRoll >= 100){
                                    app.updatePlayerPositionOnBord(player1, 100);
                                    app.displayBoard();

                                    System.out.print("Hooray you won!!!!!");
                                    System.exit(0);
                                }

                                app.movePlayer(player1, diceRoll);

                                System.out.println("PLayer roller: " + diceRoll);
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
