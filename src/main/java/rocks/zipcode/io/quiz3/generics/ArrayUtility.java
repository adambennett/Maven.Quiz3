package rocks.zipcode.io.quiz3.generics;

import java.util.*;
import java.util.function.*;

/**
 * @author leon on 09/12/2018.
 */
public class ArrayUtility<SomeType> {
    private final SomeType[] array;

    public ArrayUtility(SomeType[] array) {
        this.array = array;
    }

    public SomeType findOddOccurringValue() {
        Map<SomeType, Integer> occurrences = new HashMap<>();
        for (SomeType t : array) {
            if (occurrences.containsKey(t)) {
                occurrences.put(t, occurrences.get(t) + 1);
            } else {
                occurrences.put(t, 1);
            }
        }
        int highestOddOcc = 0;
        SomeType toRet = null;
        for (Map.Entry<SomeType, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > highestOddOcc && entry.getValue()%2!=0) {
                highestOddOcc = entry.getValue();
                toRet = entry.getKey();
            }
        }
        return toRet;
    }

    public SomeType findEvenOccurringValue() {
        Map<SomeType, Integer> occurrences = new HashMap<>();
        for (SomeType t : array) {
            if (occurrences.containsKey(t)) {
                occurrences.put(t, occurrences.get(t) + 1);
            } else {
                occurrences.put(t, 1);
            }
        }
        int highestOddOcc = 0;
        SomeType toRet = null;
        for (Map.Entry<SomeType, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > highestOddOcc && entry.getValue()%2==0) {
                highestOddOcc = entry.getValue();
                toRet = entry.getKey();
            }
        }
        return toRet;
    }

    public Integer getNumberOfOccurrences(SomeType valueToEvaluate) {
        Map<SomeType, Integer> occurrences = new HashMap<>();
        for (SomeType t : array) {
            if (occurrences.containsKey(t)) {
                occurrences.put(t, occurrences.get(t) + 1);
            } else {
                occurrences.put(t, 1);
            }
        }
        return occurrences.get(valueToEvaluate);
    }

    public SomeType[] filter(Function<SomeType, Boolean> predicate) {
        ArrayList<SomeType> newArr = new ArrayList<>();
        for (SomeType t : this.array) {
            if (predicate.apply(t)) {
                newArr.add(t);
            }
        }
        SomeType[] toR;
        if (newArr.size() > 0) {
            toR = (SomeType[]) java.lang.reflect.Array.newInstance(newArr.get(0).getClass(), newArr.size());
            int i = 0;
            for (SomeType t : newArr) {
                toR[i] = t;
                i++;
            }
        } else {
            toR = (SomeType[]) java.lang.reflect.Array.newInstance(Integer.class, newArr.size());
        }
        return toR;
    }
}
