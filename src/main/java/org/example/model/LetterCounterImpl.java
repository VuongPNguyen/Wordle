package org.example.model;

import java.util.HashMap;

public class LetterCounterImpl implements LetterCounter {
  private final HashMap<Character, Integer> counter = new HashMap<>();
  private final char[] alphabet =
      new char[] {
          'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
          's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
      };

  public LetterCounterImpl() {
    for (char letter : alphabet) {
      counter.put(Character.toUpperCase(letter), 0);
    }
  }

  @Override
  public void resetCount() {
    for (char letter : alphabet) {
      counter.put(Character.toUpperCase(letter), 0);
    }
  }

  @Override
  public void addOne(char key) {
    counter.put(Character.toUpperCase(key), counter.get(key) + 1);
  }

  @Override
  public void subOne(char key) {
    char upperKey = Character.toUpperCase(key);
    if (this.getCount(upperKey) > 0)  {
      counter.put(upperKey, counter.get(upperKey) - 1);
    }
  }

  @Override
  public int getCount(char key) {
    return counter.get(Character.toUpperCase(key));
  }
}
