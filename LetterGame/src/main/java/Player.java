
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicolas
 */
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
