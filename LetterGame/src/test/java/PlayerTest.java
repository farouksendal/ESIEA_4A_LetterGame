/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Player.Player;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class PlayerTest {
    
    Player p;
    
    @Before
    public void setUp() {
        p = new Player("Nico");
    }

    /**
     * Test of getListOfLetter method, of class Player.
     */
    @Test
    public void testGetListOfLetter() {
        System.out.println("getListOfLetter");
        ArrayList<Character> list = new ArrayList<Character>();
        list.add(Character.valueOf('c'));
        p.addLetterToListOfLetter(Character.valueOf('c'));
        
        
        ArrayList<Character> expResult = list;
        ArrayList<Character> result = p.getListOfLetter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Nico";
        String result = p.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeWord method, of class Player.
     */
    @Test
    public void testRemoveWord() {
        System.out.println("removeWord");
        p.addWord("test");
        p.addWord("test2");
        p.removeWord(String.valueOf("test"));
        assertEquals(1,p.getListOfWord().size());
        
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Nicoo";
        p.setName(name);
        assertEquals("Nicoo",p.getName());
    }

    /**
     * Test of getListOfWord method, of class Player.
     */
    @Test
    public void testGetListOfWord() {
        System.out.println("getListOfWord");
        ArrayList<String> list = new ArrayList<String>();
        list.add("test");
        p.addWord("test");
        ArrayList<String> expResult = list;
        ArrayList<String> result = p.getListOfWord();
        assertEquals(expResult, result);
    }

    
    
}
