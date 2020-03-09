package rocks.zipcode.io.quiz3.fundamentals;

import java.util.*;

/**
 * @author leon on 09/12/2018.
 */
public class StringUtils {
    public static String capitalizeNthCharacter(String str, Integer indexToCapitalize) {
        String toRet = "";
        int index = 0;
        for (char c : str.toCharArray()) {
            Character ch = c;
            if (index != indexToCapitalize) {
                toRet += ch;
            } else {
                toRet += ch.toString().toUpperCase();
            }
            index++;
        }
        return toRet;
    }

    public static Boolean isCharacterAtIndex(String baseString, Character characterToCheckFor, Integer indexOfString) {
        if (baseString.length() < indexOfString) {
            return false;
        }
        return baseString.charAt(indexOfString) == (characterToCheckFor);
    }

    public static String[] getAllSubStrings(String string) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int k = 1; k <= string.length() - i; k++) {
                substrings.add(string.substring(i, i+k));
            }
        }
        String[] sub = new String[substrings.size()];
        int i = 0;
        for (String s : substrings) {
            sub[i] = s;
            i++;
        }
        return sub;
    }

    public static Integer getNumberOfSubStrings(String input){
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int k = 1; k <= input.length() - i; k++) {
                substrings.add(input.substring(i, i+k));
            }
        }
        return substrings.size();
    }
}
