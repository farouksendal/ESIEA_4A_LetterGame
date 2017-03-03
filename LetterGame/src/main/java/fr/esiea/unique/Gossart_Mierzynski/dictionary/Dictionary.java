import fr.esiea.unique.Gossart_Mierzynski.dictionary.IDictionary;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary implements IDictionary{

    private static Dictionary instance = null;
    private ArrayList <String> dico;
    private String filePath = "src/main/resources/dico.txt";

    /**
     * Le constructeur du dictionnaire initialise la liste des mots
     */
    private Dictionary () {
        try {
            dico = readStream(filePath);
        }  catch (IOException e) {
            System.err.println("Le fichier " + dico + " n'existe pas !");
        }
    }

    /**
     * @return retourne une instance de l'objet Dictionnaire
     */
    public static Dictionary getInstance() {
        if(instance==null)
            instance =new Dictionary();
        return  instance;
    }

    /**
     *
     * @param fileName
     * @return retourne la liste des mots à partir d'un flux
     * @throws IOException Declenche une exception au cas où le fichier n'existe pas
     */
    private static ArrayList<String> readStream(String fileName) throws IOException {
        ArrayList <String> wordList = new ArrayList <String> ();
        BufferedReader dic = new BufferedReader(new FileReader(fileName));
        String line;

        while((line = dic.readLine()) != null)
        {
            wordList.add(line);
        }
        dic.close();

        return wordList;
    }

    /**
     *  Méthode vérifie si le mot existe dans le dictionnaire ou pas
     * @param word Le mot qu'on cherche
     * @return true = le mot existe , false = le mot n'existe pas
     */
    public boolean isWord(String word) {

        return dico.contains(word);
    }


    /**
     *
     * @return Getter de la liste des mots générés à partir du dictionnaire
     */
    public ArrayList<String> getDico() {
        return dico;
    }



}
