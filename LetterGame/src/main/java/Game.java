
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import fr.esiea.unique.Gossart_Mierzynski.dictionary.UtilString;
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

    }

    public void getANickname() {
        for (int i = 1; i <= numberOfPlayer; i++) {
            System.out.print("Pick a nickname player number " + i + ": ");
            scanner = new Scanner(System.in);
            players.add(new Player(scanner.next()));
        }
    }

    public void whosFirst() {
        for (Player player : players) {
            pickOneLetter(player);
        }
        sortLetter();
    }

    public void pickOneLetter(Player player) {

        player.addLetterToListOfLetter(getRandomLetter());
        pool.add(player.getLastLetter());
    }

    public void pickTwoLetter(Player player) {

        for (int i = 0; i < 2; i++) {
            pickOneLetter(player);
        }
    }

    public char getRandomLetter() {

        Random random = new Random();
        char firstLetter = (char) (random.nextInt(26) + 'a');
        return firstLetter;

    }

    public void sortLetter() {
        Collections.sort(players, new Comparator<Player>() {
            public int compare(Player o1, Player o2) {
                return o1.getLastLetter() < o2.getLastLetter() ? -1 : 1;
            }
        });
    }

    public void playerPickTwoLetter() {
        String word;
        for (Player player : players) {

            display.WitchTurn(player);
            
   
            pickOneLetter(player);
            pickOneLetter(player);
            display.whatLetterWasPicked(player);
            System.out.println(pool.get(pool.size() - 2) + " and " +pool.get(pool.size() - 1));
            System.out.println("Letter in the Common pot : " + pool.toString());
            display.menu();
            scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    display.EnterWord();
                    scanner = new Scanner(System.in);
                    word = scanner.next();
                    Player p = player.existantWord(players, word);
                    if (word.length() > pool.size()) {
                       display.wrongWord(player);
                    } else if (p != null) {
                        String tempWord;

                        player.addWord(word);
                    } else {
                        String temp = word;
                        int wordLength = word.length();
                        int counter = UtilString.findWordInCharList(pool, temp);

                        if (counter == wordLength && dictionary.isWord(word)) {
                            player.addWord(word);
                            System.out.println("Le joueur " + p.getName() + " a trouvé le mot : " + word + ". Bravo!");
                            if (p.getListOfWord().size() > 9) {
                                gameState = false; // Game over
                                p.setWin(true);
                                System.out.println("Le joueur  " + p.getName() + " a gagné !");
                            }
                            pickOneLetter(p);
                            for (char c : word.toCharArray()) {
                                pool.remove(c);
                            }
                        } else {
                            System.out.println("Le mot n'existe pas! Le joueur " + p.getName() + " passe son tour !");
                        }

                    }
                    break;
                }
                case 2: {
                    // on fait rien
                    break;
                }
                default: {
                    System.out.println("Je n'ai pas compris votre choix. Essayer à nouveau !");
                    break;
                }

            }

        }
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

}
