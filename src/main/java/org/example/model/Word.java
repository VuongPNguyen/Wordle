package org.example.model;

public interface Word {
  /** Getter for char at given index. */
  Letter getLetterAtIndex(int index);

  /** Getter for length of Word. */
  int getLength();
}
