
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicolas
 */
public final class InitialisationGame {

    protected Scanner scanner;
    protected ArrayList<Player> players;
    int numberOfPlayer;

    public InitialisationGame(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        players = new ArrayList<Player>();
        getANickname();
    }

    public void getANickname() {
        for (int i = 1; i <= numberOfPlayer; i++) {
            System.out.print("Pick a nickname player number " + i + ": ");
            scanner = new Scanner(System.in);
            players.add(new Player(scanner.next()));
        }
    }

    public void whosFirst()
    {
        
    }

}
