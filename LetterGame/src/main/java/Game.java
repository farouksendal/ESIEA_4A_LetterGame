
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
public class Game {

    protected ArrayList<Player> players;
    //protected Scanner scanner;
    protected int numberOfPlayer;

    public Game(int numberOfPlayer) {
        
        players = new ArrayList<Player>();
        
        this.numberOfPlayer = numberOfPlayer;
        new InitialisationGame(numberOfPlayer); 
        
    }

    
    
}
