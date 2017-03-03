package Player;


import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Character> listOfLetter;
    private ArrayList<String> listOfWord;
    private boolean winGame;

    public Player(String name) {
        this.name = name;
        listOfLetter = new ArrayList<Character>();
        listOfWord = new ArrayList<String>();
    }

    public Player() {

    }

    public Player(String name, ArrayList<Character> listOfLetter) {
        this.name = name;
        this.listOfLetter = listOfLetter;
    }

    public Player(ArrayList<Character> listOfLetter) {
        this.listOfLetter = listOfLetter;
    }

    public ArrayList<Character> getListOfLetter() {
        return listOfLetter;
    }

    public String getName() {
        return name;
    }

    public void removeWord(String word) {
        listOfWord.remove(word);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListOfWord() {
        return listOfWord;
    }

    public void addLetterToListOfLetter(char letter) {
        listOfLetter.add(letter);
    }

    public void addWord(String word) {
        listOfWord.add(word);
    }

    public char getLetter() {
        return listOfLetter.get(listOfLetter.size() - 1);
    }

    public char getLastLetter() {
        return listOfLetter.get(listOfLetter.size() - 1);
    }

    public String existantWord(ArrayList<Player> playersparam, String word) {
        for (Player p : playersparam) {
            if (!p.equals(this)) {
                for (String w : p.getListOfWord()) {
                    if (word.contains(w)) {
                        return w;
                    }
                }
            }
        }
        return "";
    }

    public void setWin(boolean win) {
        this.winGame = win;
    }

}
