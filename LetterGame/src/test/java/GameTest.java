/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Player.Player;
import game.Game;
import fr.esiea.unique.Gossart_Mierzynski.dictionary.Dictionary;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class GameTest {

    Game game;

    @Before
    public void setUp() {
        game= new Game(2);
    }

    /**
     * Test of whosFirst method, of class Game.
     */
    @Test
    public void testWhosFirst() {
        System.out.println("whosFirst");
        Player p1 = new Player("nico");
        p1.addLetterToListOfLetter('c');
        Player p2 = new Player("nicoo");
        p2.addLetterToListOfLetter('d');
        assertEquals(1,p1.getListOfLetter().size());
        assertEquals(1,p2.getListOfLetter().size());
        
    }


    /**
     * Test of isWinner method, of class Game.
     */
    @Test
    public void testIsWinner() {
        System.out.println("isWinner");
        Player player = new Player("bidule");
        for(int i=0;i<10;i++)
            player.addWord("toto");
        boolean result = game.isWinner(player);
        assertTrue(result);
    }

}
