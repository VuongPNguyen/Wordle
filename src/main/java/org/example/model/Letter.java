package org.example.model;

public interface Letter {
  /** Getter method for letter. */
  char getLetter();

  /** Getter method for index. */
  int getIndex();

  /**
   * Compare method for Letter. Case-insensitive.
   * @return
   * -1 = Different letter and index.<br>
   * 0 = Same letter, different index.<br>
   * 1 = Same letter and index.
   */
  int compareTo(Letter other);
}
