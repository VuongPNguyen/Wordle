package org.example.model;

public interface Word {
  /** Getter for char at given index. */
  char getCharAtIndex(int index);

  /** Getter for length of Word. */
  int getLength();

  /** @return True if word list contains the letter. */
  boolean containsLetter(char letter);

  /** Adds letter at the end of the word. */
  void addLetter(char letter);

  /** Removes the letter at the given index. */
  void removeLetter();

  /** Gets the last letter of the word. Throws NoSuchElementException if empty. */
  char getLastChar();

  /**
   * Compare method for Word. Case-insensitive.
   * @return
   * -1 = Invalid comparison.<br>
   * 0 = Not equal.<br>
   * 1 = Equal.
   */
  int compareTo(Word other);
}
