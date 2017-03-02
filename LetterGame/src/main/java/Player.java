
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Character> listOfLetter;
    private ArrayList<String> listOfWord;

    public Player(String name) {
        this.name = name;
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

}
