package org.example.model;

import java.util.Arrays;

public class WordleImpl implements Wordle {
  private Word guess, answer;
  private LetterCounter guessCounter, answerCounter;
  private int attempt = 0;


  public WordleImpl(String answer) {
    this.answer = new WordImpl(answer);
    this.guess = new WordImpl("");
    answerCounter = new LetterCounterImpl();
    guessCounter = new LetterCounterImpl();

    for (int i = 0; i < this.answer.getLength(); i++) {
      answerCounter.addOne(this.answer.getCharAtIndex(i));
    }
  }

  @Override
  public int[] submitGuess() {
    int wordLength = answer.getLength();

    if (guess.getLength() != wordLength) {
      throw new IllegalArgumentException("Guess is not the same length as Answer.");
    }

    int[] responseArray = new int[wordLength];

    // Checks if guess is correct.
    if (this.compareGuessToAnswer()) {
      Arrays.fill(responseArray, 1);
      return responseArray;
    }

    for (int index = 0; index < wordLength; index++) {
      if (this.isLetterCorrect(guess.getCharAtIndex(index), index)) {
        responseArray[index] = 1;
      } else if (this.isLetterInAnswer(guess.getCharAtIndex(index))) {
        responseArray[index] = 0;
      } else {
        responseArray[index] = -1;
      }
    }
    // Reset and update.
    attempt += 1;
    resetGuess();

    return responseArray;
  }

  @Override
  public void addLetter(char letter) {
    if (guess.getLength() < answer.getLength()) {
      guess.addLetter(letter);
      guessCounter.addOne(letter);
    }
  }

  @Override
  public void removeLetter() {
    if (guess.getLength() > 0) {
      guessCounter.subOne(guess.getLastChar());
      guess.removeLetter();
    }
  }

  /**
   * Updates guess hashmap at the key.
   *
   * @param relValue The relative value to add or subtract to the value at the key. Will not go
   *     negative.
   */
  private void updateGuessHashMap(char key, int relValue) {

  }

  @Override
  public boolean compareGuessToAnswer() {
    if (guess == null) {
      throw new IllegalArgumentException("Guess is null.");
    }
    return answer.compareTo(guess) == 1;
  }

  @Override
  public boolean isLetterCorrect(char letter, int index) {
    return answer.getCharAtIndex(index) == Character.toUpperCase(letter);
  }

  @Override
  public boolean isLetterInAnswer(char letter) {
    return answer.containsLetter(Character.toUpperCase(letter));
  }

  @Override
  public void resetGuess() {
    this.setGuess(new WordImpl(""));
  }

  @Override
  public void generateNewAnswer() {}

  @Override
  public Word getGuess() {
    return guess;
  }

  @Override
  public void setGuess(Word guess) {
    this.guess = guess;
  }

  @Override
  public Word getAnswer() {
    return answer;
  }

  @Override
  public void setAnswer(Word answer) {
    this.answer = answer;
  }

  @Override
  public int getAttempt() {
    return attempt;
  }
}
