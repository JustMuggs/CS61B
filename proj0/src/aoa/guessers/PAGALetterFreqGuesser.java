package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PAGALetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PAGALetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN and the GUESSES that have been made. */
    public char getGuess(String pattern, List<Character> guesses) {
        Map<Character, Integer> map = this.getFreqMapThatMatchesPattern(pattern, guesses);

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

    public List<String> keepOnlyWordsThatMatchPattern(String pattern, List<Character> guesses) {
        List<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }

            boolean same = true;
            for (int i = 0; i < word.length(); i++) {
                if ((pattern.charAt(i) != '-' && pattern.charAt(i) != word.charAt(i)) || pattern.charAt(i) == '-' && guesses.contains(word.charAt(i))) {
                    same = false;
                    break;
                }
            }

            if (same) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    public Map<Character, Integer> getFreqMapThatMatchesPattern(String pattern, List<Character> guesses) {
        Map<Character, Integer> map = new TreeMap<>();
        List<String> matchingWords = this.keepOnlyWordsThatMatchPattern(pattern, guesses);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 26; i++) {
            char letter = alphabet.charAt(i);
            int count = 0;

            for (String word : matchingWords) {
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

    public static void main(String[] args) {
        PAGALetterFreqGuesser pagalfg = new PAGALetterFreqGuesser("data/example.txt");
        System.out.println(pagalfg.getGuess("----", List.of('e')));
    }
}
