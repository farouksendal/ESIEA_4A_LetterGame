package display;


import Player.Player;


/*/
    Class d'affichage afin de ne pas surcharger avec des System.out.println les methode "métier" du jeu, elle contient la majeur partie des affichages du jeux 
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
        System.out.println("3 - Stole a word");
    }

    public void EnterWord() {
        System.out.println("Enter a word");
    }

    public void wrongWord(Player player) {
        System.out.println("Wronf word "+ player.getName());
    }
    
    public void findWord(Player player) {
        System.out.println("Well done " + player.getName() + " you found the word : ");
    }
    public void wordStolen(Player player){
        
        System.out.println(player.getName() + " loose a word !");
    }
}
