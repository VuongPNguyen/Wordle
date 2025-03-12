package org.example.model;

public interface Word {
  /** Getter for char at given index. */
  char getLetterAtIndex(int index);

  /** Getter for length of Word. */
  int getLength();

  /**
   * Compare method for Word. Case-insensitive.
   * @return
   * -1 = Invalid comparison.<br>
   * 0 = Not equal.<br>
   * 1 = Equal.
   */
  int compareTo(Word other);
}
