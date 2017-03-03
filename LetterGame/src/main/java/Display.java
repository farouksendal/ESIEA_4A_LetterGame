/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolas
 */
public class Display {

    public void Welcome() {

        System.out.println("Welcome in LetterGame.");

    }

    public void NumberOfPlayer() {

        System.out.println("Enter the number of players.");

    }

    public void ErrorNumberOfPlayer() {

        System.out.println("Error, invalide number of players");

    }

    public void WitchTurn(Player player) {
        System.out.println("\nIt's " + player.getName() + "' turns");
    }

    public void whatLetterWasPicked(Player player) {
        System.out.println(player.getName() + " picked two letter :");
    }

    public void menu() {
        System.out.println("1 : Make a word");
        System.out.println("2 - I pass");
    }

    public void EnterWord() {
        System.out.println("Enter a word");
    }

    public void wrongWord(Player player) {
        System.out.println("Wronf word "+ player.getName());
    }

}
