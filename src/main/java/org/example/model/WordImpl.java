package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class WordImpl implements Word {
  private final List<Character> word = new ArrayList<>();

  public WordImpl(String word) {
    for (int index = 0; index < word.length(); index++) {
      if (!Character.isAlphabetic(word.charAt(index))) {
        throw new IllegalArgumentException("Character at index[" + index + "] is not alphabetic.");
      }
      this.word.add(Character.toUpperCase(word.charAt(index)));
    }
  }

  @Override
  public char getCharAtIndex(int index) {
    return word.get(index);
  }

  @Override
  public int getLength() {
    return word.size();
  }

  @Override
  public boolean containsLetter(char letter) {
    return word.contains(letter);
  }

  @Override
  public void addLetter(char letter) {
    if (!Character.isAlphabetic(letter)) {
      throw new IllegalArgumentException(letter + " is not alphabetic.");
    }
    word.add(Character.toUpperCase(letter));
  }

  @Override
  public void removeLetter() {
    word.remove(word.size() - 1);
  }

  @Override
  public char getLastChar() {
    if (this.getLength() > 0) {
      return word.getLast();
    }
    return '?';
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
      if (this.getCharAtIndex(i) != other.getCharAtIndex(i)) {
        return 0;
      }
    }
    // Every check passes, meaning equal.
    return 1;
  }

  @Override
  public String toString() {
    char[] charArray = new char[this.getLength()];
    for (int i = 0; i < this.getLength(); i++) {
      charArray[i] = this.getCharAtIndex(i);
    }
    return String.valueOf(charArray);
  }
}
