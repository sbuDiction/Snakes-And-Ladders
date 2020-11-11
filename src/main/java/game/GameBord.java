package game;

import game.player.Player;

import java.util.Scanner;

public class GameBord {

    public static void main(String[] args) {
        App app = new App();
        Player player1 = new Player();
        Scanner scanner = new Scanner(System.in);
        app.buildBord();
        System.out.println("Welcome to Snakes and Ladders");
        while (true) {
            System.out.println("\nDo you want to roll?\nYes/No");
            String strInput = scanner.nextLine();
            System.out.println(strInput);
            if (strInput.equals("yes")) {
                int diceRoll = player1.rollDice();
                app.movePlayer(player1, diceRoll);
                int sum = player1.getPosition() - diceRoll;
                System.out.println("Player moved from: " + sum + " to ");
            }
        }
    }
}
