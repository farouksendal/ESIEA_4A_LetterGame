package game;


import display.Display;
import Player.Player;
import fr.esiea.unique.Gossart_Mierzynski.dictionary.Dictionary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import fr.esiea.unique.Gossart_Mierzynski.dictionary.Utilitaire;
import java.util.Comparator;

public class Game extends AbstractGame {

    Display display = new Display();
    protected Scanner scanner;
    protected ArrayList<Player> players;
    int numberOfPlayer;
    protected Dictionary dictionary;

    public Game(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        players = new ArrayList<Player>();
        dictionary = Dictionary.getInstance();
    }
    //permet de choisir un nom pour chaque joueur
    public void getANickname() {
        for (int i = 1; i <= numberOfPlayer; i++) {
            System.out.print("Pick a nickname player number " + i + ": ");
            scanner = new Scanner(System.in);
            players.add(new Player(scanner.next()));
        }
    }
    
    //determine qui joue le premier
    public void whosFirst() {
        for (Player player : players) {
            pickOneLetter(player);
        }
        sortLetter();
    }
    
    //pioche une lettre
    public void pickOneLetter(Player player) {

        player.addLetterToListOfLetter(getRandomLetter());
        pool.add(player.getLastLetter());
    }
    
    //retourne une lettre random dans l'alphabet
    public char getRandomLetter() {

        Random random = new Random();
        char firstLetter = (char) (random.nextInt(26) + 'a');
        return firstLetter;

    }
    
    //tri deux lettre afin de savoir qu'elle est la plus petite
    public void sortLetter() {
        Collections.sort(players, new Comparator<Player>() {
            public int compare(Player o1, Player o2) {
                return o1.getLastLetter() < o2.getLastLetter() ? -1 : 1;
            }
        });
    }
    
    //corp du jeu qui permet de faire piocher chaque joueur deux lettre et de faire/voler des mots
    public void playerPickTwoLetter() {
        String word;

        int keypressed;
        for (Player player : players) {
            boolean choice = false;
            display.WitchTurn(player);

            pickOneLetter(player);
            pickOneLetter(player);
            display.whatLetterWasPicked(player);
            System.out.println(pool.get(pool.size() - 2) + " and " + pool.get(pool.size() - 1));
            System.out.println("Letter in the Common pot : " + pool.toString());

            while (!choice) {
                display.menu();

                try {
                    keypressed = scanner.nextInt();
                } catch (Exception e) {
                    keypressed = 0;
                }
                switch (keypressed) {

                    default: {
                        System.out.println("Try again");
                        break;
                    }

                    case 1: {
                        choice = true;
                        display.EnterWord();
                        scanner = new Scanner(System.in);
                        word = scanner.next();
                        choiceOne(word, player);
                    }
                    case 2: {
                        choice = true;
                        break;
                    }
                    case 3: {
                        choice = true;
                        display.EnterWord();
                         scanner = new Scanner(System.in);
                        word = scanner.next();
                        choiceThree(word,player);
                    }

                }
            }

        }
    }
    
    //determine si le mot se trouve dans le dictionnaire ou non
    public void choiceOne(String word, Player player) {

        if (word.length() > pool.size()) {
            display.wrongWord(player);
        } else {
            String temp = word;
            int wordLength = word.length();
            int counter = Utilitaire.findWordInCharList(pool, temp);

            if (counter == wordLength && dictionary.isWord(word)) {
                player.addWord(word);
                display.findWord(player);
                System.out.println(word);
                isWinner(player);
                pickOneLetter(player);
                for (char c : word.toCharArray()) {
                    pool.remove(Character.valueOf(c));
                }
            } else {
                display.wrongWord(player);
            }

        }

    }
    
    //permet de voler le mot de l'autre joueur
    public void choiceThree(String word, Player player) {

        String existantWord = player.existantWord(players, word);
        if (!existantWord.equals("")) {
            for (Player tp : players) {
                if (tp.getListOfWord().contains(existantWord)) {
                    tp.removeWord(existantWord);
                    player.addWord(word);
                    display.findWord(player);
                    System.out.println(word);
                    
                    display.wordStolen(player);
                    pickOneLetter(player);
                    String subWord = word.replace(existantWord, "");
                    for (char c : subWord.toCharArray()) {
                        pool.remove(Character.valueOf(c));
                    }
                }
            }
        } else {
            display.wrongWord(player);
        }
    }
    
    //recupere le dictionaire
    public Dictionary getDictionary() {
        return dictionary;
    }
    
    //permet de savoir si le joueur gagne la partie
    public boolean isWinner(Player player) {
        if (player.getListOfWord().size() > 9) {
            gameState = false;
            player.setWin(true);
            System.out.println(player.getName() + " you win ");
            return true;
        }
        return false;
    }

    public ArrayList <Player> getPlayers()
    {
        return players;
    }
}
