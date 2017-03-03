package game;


import display.Display;
import game.Game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        Display display = new Display();

        Game launchGame;

        int numberOfPlayer = 0;

        display.Welcome();
        String inputString;
        display.NumberOfPlayer();
        Scanner user_input = new Scanner(System.in);
        numberOfPlayer = -1;
        inputString = user_input.nextLine();

        try {
            numberOfPlayer = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            numberOfPlayer = -1;
        }
        
        //demande le nombre de joueur, minimum 2 joueurs, tout seul c'est moin marrant !
        while (numberOfPlayer < 2) {
            display.ErrorNumberOfPlayer();
            display.NumberOfPlayer();
            inputString = user_input.next();

            try {
                numberOfPlayer = Integer.parseInt(inputString);
            } catch (InputMismatchException e) {
                numberOfPlayer = -1;
            }
        }

        //lancement du jeu
        try {
            launchGame = new Game(numberOfPlayer);
            launchGame.playTheGame();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
