
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;




import java.util.ArrayList;
import java.util.Dictionary;
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
public abstract class AbstractGame {
    


    protected ArrayList<Character> pool;
    protected Dictionary dictionary;
    protected boolean gameState;
    
    public AbstractGame() {
        //initialisation
    
        pool = new ArrayList<Character>();
    }
    
        public void playTheGame() {
            
        getANickname();
        whosFirst();
       //while (gameState)
           playerPickTwoLetter();
    }

    public abstract void getANickname();

    public abstract void whosFirst();
    
    public abstract void playerPickTwoLetter();
    }

