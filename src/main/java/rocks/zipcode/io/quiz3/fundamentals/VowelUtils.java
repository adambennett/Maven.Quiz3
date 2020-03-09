package rocks.zipcode.io.quiz3.fundamentals;

import java.util.*;

/**
 * @author leon on 09/12/2018.
 */
public class VowelUtils {

    private static ArrayList<Character> vowels;

    static {
        vowels = new ArrayList<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public static Boolean hasVowels(String word) {
        ArrayList<Character> wordChars = new ArrayList<>();
        for (char c : word.toCharArray()){
            wordChars.add(c);
        }
        for (Character c : vowels) {
            if (wordChars.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static Integer getIndexOfFirstVowel(String word) {
        ArrayList<Character> wordChars = new ArrayList<>();
        int index = 0;
        for (char c : word.toCharArray()){
            if (isVowel(c)) {
                return index;
            }
            index++;
        }
        return -1;
    }


    public static Boolean startsWithVowel(String word) {
        return isVowel(word.charAt(0));
    }

    public static Boolean isVowel(Character character) {
        return (character != null) && vowels.contains(character);
    }
}
