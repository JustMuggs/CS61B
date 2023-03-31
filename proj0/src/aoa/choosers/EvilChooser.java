package aoa.choosers;

import aoa.utils.FileUtils;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EvilChooser implements Chooser {
    private String pattern;
    private List<String> wordPool;

    public EvilChooser(int wordLength, String dictionaryFile) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("Word length must be at least 1 character long");
        }

        this.wordPool = FileUtils.readWordsOfLength(dictionaryFile, wordLength);

        if (this.wordPool.isEmpty()) {
            throw new IllegalStateException("There are no words found with the given length");
        }

        this.pattern = "-".repeat(wordLength);

    }

    @Override
    public int makeGuess(char letter) {
        Map<String, List<String>> map = new TreeMap<>();
        for (String word : this.wordPool) {
            String pattern = this.getWordPattern(word, letter);
            if (map.containsKey(pattern)) {
                map.get(pattern).add(word);
            } else {
                List<String> n = new ArrayList<>();
                n.add(word);
                map.put(pattern, n);
            }
        }

        int maxSize = 0;
        for (List<String> list : map.values()) {
            if (list.size() > maxSize) {
                maxSize = list.size();
            }
        }

        for (String pattern : map.keySet()) {
            if (map.get(pattern).size() == maxSize) {
                this.pattern = pattern;
                this.wordPool = map.get(pattern);
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < this.pattern.length(); i++) {
            if (this.pattern.charAt(i) == letter) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public String getWord() {
        if (this.wordPool.size() == 1) {
            return this.wordPool.get(0);
        }
        return this.wordPool.get(StdRandom.uniform(this.wordPool.size()));
    }

    private String getWordPattern(String word, char letter) {
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                pattern.append(letter);
            } else {
                pattern.append(this.pattern.charAt(i));
            }
        }
        return pattern.toString();
    }
}
