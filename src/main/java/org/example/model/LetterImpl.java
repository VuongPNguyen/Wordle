package org.example.model;

public class LetterImpl implements Letter, Comparable<Letter> {
  private final char letter;
  private final int index;

  public LetterImpl(char letter, int index) {
    this.letter = letter;
    this.index = index;
  }

  @Override
  public char getLetter() {
    return letter;
  }

  @Override
  public int getIndex() {
    return index;
  }

  @Override
  public int compareTo(Letter other) {
    if (letter == other.getLetter()) {
      if (index == other.getIndex()) {
        return 1; // When letter and index are the same.
      } else {
        return 0; // When letter is the same, but not index.
      }
    } else {
      return -1; // When nothing is the same.
    }
  }
}
