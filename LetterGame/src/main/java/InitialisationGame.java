
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
public class InitialisationGame {

    protected Scanner scanner;
    protected ArrayList<Player> players;
    private ArrayList<Character> pool;
    int numberOfPlayer;

    public InitialisationGame(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        players = new ArrayList<Player>();
        getANickname();
        whosFirst();
    }

    public void getANickname() {
        for (int i = 1; i <= numberOfPlayer; i++) {
            System.out.print("Pick a nickname player number " + i + ": ");
            scanner = new Scanner(System.in);
            players.add(new Player(scanner.next()));
        }
    }

    public void whosFirst() {
        for(Player player: players){
            pickOneLetter(player);
        }
        sortLetter();
    }
    public void pickOneLetter(Player player){
        
       player.addLetterToListOfLetter(getRandomLetter());
        
    }
    
    public void pickTwoLetter(Player player){
        
        for(int i = 0 ; i<2; i++){
            pickOneLetter(player);
        }
    }
    
    public char getRandomLetter() {

        Random random = new Random();
        char firstLetter = (char) (random.nextInt(26) + 'a');
        return firstLetter;
        
    }
    
    public void sortLetter() {

        Collections.sort(players, (Player arg1, Player arg2) -> {
            return Character.compare(arg1.getLetter(), arg2.getLetter());
        });
        
    }

}
