package org.example.model;

public class WordImpl implements Word, Comparable<Word> {
  private final Letter[] word;

  public WordImpl(String word) {
    this.word = new Letter[word.length()];

    for (int index = 0; index < word.length(); index++) {
      this.word[index] = new LetterImpl(word.charAt(index), index);
    }
  }

  public WordImpl(Letter[] word) {
    for(int index = 0; index < word.length; index++) {
      if (word[index] == null) {
        throw new IllegalArgumentException("Letter[" + index + "] is null.");
      }
    }
    this.word = word;
  }

  @Override
  public char getLetterAtIndex(int index) {
    return word[index].getLetter();
  }

  @Override
  public int getLength() {
    return word.length;
  }

  @Override
  public int compareTo(Word other) {
    if (other == null) {
      throw new IllegalArgumentException("Other Word is null.");
    }
    // Ensure the length equals.
    if (this.getLength() != other.getLength()) {
      return -1;
    }
    // Check every letter is the same.
    for (int i = 0; i < this.getLength(); i++) {
      if (this.getLetterAtIndex(i) != other.getLetterAtIndex(i)) {
        return 0;
      }
    }
    // Every check passes, meaning equal.
    return 1;
  }
}
