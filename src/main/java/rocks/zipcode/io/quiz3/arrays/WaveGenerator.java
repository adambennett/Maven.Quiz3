package rocks.zipcode.io.quiz3.arrays;

/**
 * @author leon on 09/12/2018.
 */
public class WaveGenerator {
    public static String[] wave(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            Character ca = c;
            if (Character.isAlphabetic(ca)) {
                count++;
            }
        }
        String[] capped = new String[count];
        for (int i = 0; i < count; i++) {
            String toAdd = "";
            int index = 0;
            for (char c : str.toCharArray()) {
                Character ca = c;
                if (Character.isAlphabetic(ca)) {
                    if (index == i) {
                        toAdd += Character.toUpperCase(ca);
                    } else {
                        toAdd += Character.toLowerCase(ca);
                    }
                    index++;
                } else {
                    toAdd += ca;
                }
            }
            capped[i] = toAdd;
        }
        return capped;
    }
}
