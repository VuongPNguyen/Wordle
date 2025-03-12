package org.example.controller;

import org.example.model.Wordle;

public class ControllerImpl implements Controller {
  private final Wordle wordle;

  public ControllerImpl(Wordle wordle) {
    this.wordle = wordle;
  }

  @Override
  public void inputCharacter(char letter) {
    if (wordle.getGuess().getLength() < wordle.getAnswer().getLength()) {
      wordle.addLetter(letter);
    }
  }

  @Override
  public void removeCharacter() {
    if (wordle.getGuess().getLength() > 0) {
      wordle.removeLetter();
    }
  }

  @Override
  public void submitGuess() {
    if (wordle.getGuess().getLength() == wordle.getAnswer().getLength()) {
      wordle.submitGuess();
    }
  }
}
