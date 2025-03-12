package org.example.model;

public interface LetterCounter {
  void resetCount();

  void addOne(char key);

  void subOne(char key);

  int getCount(char key);
}
