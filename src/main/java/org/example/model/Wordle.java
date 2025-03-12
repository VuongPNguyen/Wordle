package org.example.model;

public interface Wordle {
  /**
   * Submits the guess for comparison. Guess should be reset after guessing.
   *
   * @return Array of integers:<br>
   *     1: correct/green<br>
   *     0: in word/yellow<br>
   *     -1: incorrect/gray
   */
  int[] submitGuess();

  /** Adds a letter to a word. */
  void addLetter(char letter);

  /** Removes the letter from the end of the guess word. */
  void removeLetter();

  /**
   * Compare the guess to the answer.
   *
   * @return true if guess == answer.
   */
  boolean compareGuessToAnswer();

  /** Checks if the letter has the correct char at the correct index. */
  boolean isLetterCorrect(char letter, int index);

  /** Checks if the letter is in the word. Index is not considered. */
  boolean isLetterInAnswer(char letter);

  /** Resets the guess word to blank. */
  void resetGuess();

  /** Sets a new word for the answer. */
  void generateNewAnswer();

  /** Getter method for guess Word. */
  Word getGuess();

  /** Setter method for the guess Word. */
  void setGuess(Word guess);

  /** Getter method for the answer Word. */
  Word getAnswer();

  /** Setter method for the answer Word. */
  void setAnswer(Word answer);

  /** Getter method for the attempt count. */
  int getAttempt();
}
