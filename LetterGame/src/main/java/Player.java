
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Character> listOfLetter;
    private ArrayList<String> listOfWord;

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
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListOfWord() {
        return listOfWord;
    }
    
        public void addLetterToListOfLetter(char letter)
    {
        listOfLetter.add(letter);
    }
    
        public char getLetter()
    {
        return listOfLetter.get(listOfLetter.size()-1);
    }
            public char getLastLetter()
    {
        return listOfLetter.get(listOfLetter.size()-1);
    }
}
