import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /**
     * Returns the total sum in a list of integers
     */
    public static int sum(List<Integer> L) {
        if (L.size() == 0) {
            return 0;
        }
        int total = 0;
        for (Integer i : L) {
            total += i;
        }
        return total;
    }

    /**
     * Returns a list containing the even numbers of the given list
     */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evens = new ArrayList<>();
        for (Integer i : L) {
            if (i % 2 == 0) {
                evens.add(i);
            }
        }
        return evens;
    }

    /**
     * Returns a list containing the common item of the two given lists
     */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commons = new ArrayList<>();
        for (Integer i : L1) {
            if (L2.contains(i)) {
                commons.add(i);
            }
        }
        return commons;
    }


    /**
     * Returns the number of occurrences of the given character in a list of strings.
     */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
