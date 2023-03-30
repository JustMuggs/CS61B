import java.util.*;

public class MapExercises {
    /**
     * Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> map = new TreeMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            map.put(alphabet.charAt(i), i + 1);
        }
        return map;
    }

    /**
     * Returns a map from the integers in the list to their squares. For example, if the input list
     * is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer i : nums) {
            map.put(i, i * i);
        }
        return map;
    }

    /**
     * Returns a map of the counts of all words that appear in a list of words.
     */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> map = new TreeMap<>();
        Set<String> wordset = new HashSet<>();
        for (String word : words) {
            wordset.add(word);
        }
        for (String word : wordset) {
            int c = 0;
            for (String w : words) {
                if (w.equals(word)) {
                    c++;
                }
            }
            map.put(word, c);
        }
        return map;
    }
}
