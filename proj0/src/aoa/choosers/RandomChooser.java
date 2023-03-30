package aoa.choosers;

import aoa.utils.FileUtils;
import edu.princeton.cs.algs4.StdRandom;

import java.util.List;

public class RandomChooser implements Chooser {
    private final String chosenWord;
    private String pattern;

    public RandomChooser(int wordLength, String dictionaryFile) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("Word length must be at least 1 character long");
        }

        List<String> words = FileUtils.readWordsOfLength(dictionaryFile, wordLength);

        if (words.isEmpty()) {
            throw new IllegalStateException("There are no words found with the given length");
        }

        this.pattern = "-".repeat(wordLength);

        this.chosenWord = words.get(StdRandom.uniform(words.size()));
    }

    @Override
    public int makeGuess(char letter) {
        int count = 0;
        StringBuilder newPattern = new StringBuilder();
        for (int i = 0; i < this.chosenWord.length(); i++) {
            if (this.chosenWord.charAt(i) == letter) {
                count++;
                newPattern.append(letter);
            } else {
                newPattern.append(this.pattern.charAt(i));
            }
        }
        this.pattern = newPattern.toString();
        return count;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public String getWord() {
        return this.chosenWord;
    }
}
