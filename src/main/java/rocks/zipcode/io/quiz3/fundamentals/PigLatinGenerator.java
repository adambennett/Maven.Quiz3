package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class PigLatinGenerator {
    public String translate(String str) {
        String[] splice = str.split(" ");
        String finalTrans = "";
        for (String s : splice) {
            String translation = "";
            char[] inputArr = s.toCharArray();
            Boolean hasVowels = VowelUtils.hasVowels(s);
            Boolean startsWith = VowelUtils.startsWithVowel(s);
            if (hasVowels) {
                if (startsWith) {
                    translation = s + "way";
                } else {
                    int start = VowelUtils.getIndexOfFirstVowel(s);
                    for (int i = start; i < s.length(); i++) {
                        translation += inputArr[i];
                    }
                    for (int i = 0; i < start; i++) {
                        translation += inputArr[i];
                    }
                    translation = translation + "ay";
                }
            } else {
                translation = s + "ay";
            }
            finalTrans += translation + " ";
        }
        finalTrans = finalTrans.trim();
        return finalTrans;
    }
}
