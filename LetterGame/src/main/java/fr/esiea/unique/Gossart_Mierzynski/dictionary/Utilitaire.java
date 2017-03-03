package fr.esiea.unique.Gossart_Mierzynski.dictionary;

import java.util.ArrayList;

public class Utilitaire {

    /**
     * @param listOfCharacters
     * @param dictionary
     * @return
     */
    public static String findWordinDictionnary(ArrayList<Character> listOfCharacters, Dictionary dictionary) {
        ArrayList<String> words = dictionary.getDico();
        for (String word : words) {
            int wordLength = word.length();
            int counter = findWordInCharList(listOfCharacters, word);
            if (counter == wordLength)
                return word;
        }
        return "";
    }

    /**
     *
     * @param listOfCharacters
     * @param word
     * @return
     */
    public static int findWordInCharList(ArrayList<Character> listOfCharacters, String word) {
        String temp = word;
        int counter = 0;
        for (int j = 0; j < listOfCharacters.size(); j++) {
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == listOfCharacters.get(j)) {
                    temp = temp.substring(0, i) + temp.substring(i + 1);
                    counter++;
                }
            }
        }
        return counter;
    }


}
