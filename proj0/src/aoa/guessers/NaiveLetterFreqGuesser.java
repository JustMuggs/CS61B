package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NaiveLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public NaiveLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Makes a guess which ignores the given pattern. */
    public char getGuess(String pattern, List<Character> guesses) {
        return getGuess(guesses);
    }

    /**
     * Returns a map from a given letter to its frequency across all words.
     * This task is similar to something you did in hw0b!
     */
    public Map<Character, Integer> getFrequencyMap() {
        Map<Character, Integer> map = new TreeMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            char letter = alphabet.charAt(i);
            int count = 0;
            for (String word : words) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == letter) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                map.put(letter, count);
            }
        }
        return map;
    }

    /**
     * Returns the most common letter in WORDS that has not yet been guessed
     * (and therefore isn't present in GUESSES).
     */
    public char getGuess(List<Character> guesses) {
        Map<Character, Integer> map = this.getFrequencyMap();
        for (Character c : guesses) {
            if (map.containsKey(c)) {
                map.remove(c);
            }
        }
        int max = 0;
        for (Integer i : map.values()) {
            if (i > max) {
                max = i;
            }
        }
        for (Character key : map.keySet()) {
            if (map.get(key) == max) {
                return key;
            }
        }
        return '?';
    }

    public static void main(String[] args) {
        NaiveLetterFreqGuesser nlfg = new NaiveLetterFreqGuesser("data/example.txt");
        System.out.println("list of words: " + nlfg.words);
        System.out.println("frequency map: " + nlfg.getFrequencyMap());

        List<Character> guesses = List.of('e', 'l');
        System.out.println("guess: " + nlfg.getGuess(guesses));
    }
}
