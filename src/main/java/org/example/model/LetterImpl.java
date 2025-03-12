package org.example.model;

public class LetterImpl implements Letter {
  private final char letter;
  private final int index;

  public LetterImpl(char letter, int index) {
    if (!Character.isLetter(letter)) {
      throw new IllegalArgumentException("Letter character is not a letter.");
    }
    if (index < 0) {
      throw new IllegalArgumentException("Index is less than 0");
    }

    this.letter = letter;
    this.index = index;
  }

  @Override
  public char getLetter() {
    return Character.toUpperCase(letter);
  }

  @Override
  public int getIndex() {
    return index;
  }

  @Override
  public int compareTo(Letter other) {
    if (this.getLetter() == other.getLetter()) {
      if (this.getIndex() == other.getIndex()) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
}
