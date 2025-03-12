package org.example;

import org.example.model.Word;
import org.example.model.WordImpl;
import org.example.model.Wordle;
import org.example.model.WordleImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Unit test for simple App. */
@SuppressWarnings({"ReassignedVariable", "UnusedAssignment", "unused"})
public class AppTest {
  /** Test Word constructors */
  @Test
  public void testWordConstructor() {
    boolean exception = false;
    Word w;
    try {
      w = new WordImpl("abc");
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {}
    assertFalse(exception);
  }

  /** Test Word methods */
  @Test
  public void testWordMethods() {
    Word w = new WordImpl("test");
    assertEquals(4, w.getLength());
    assertEquals('T', w.getCharAtIndex(0));
    assertEquals('E', w.getCharAtIndex(1));
    assertEquals('S', w.getCharAtIndex(2));
    assertEquals('T', w.getCharAtIndex(3));
    assertTrue(w.containsLetter('T'));
  }

  /** Test Word compareTo */
  @Test
  public void testWordCompareTo() {
    Word w = new WordImpl("test");
    Word x = new WordImpl("test");
    assertEquals(1, w.compareTo(x));

    Word y = new WordImpl("tests");
    assertEquals(-1, w.compareTo(y));

    Word z = new WordImpl("nope");
    assertEquals(0, w.compareTo(z));

    boolean exception = false;
    try {
      w.compareTo(null);
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {}
    assertTrue(exception);
  }

  /** Test Word toString */
  @Test
  public void testWordToString() {
    Word w = new WordImpl("test");
    assertEquals("TEST", w.toString());
  }

  /** Test Wordle getters and setters. */
  @Test
  public void testWordleMethods() {
    Wordle w = new WordleImpl("test");
    assertEquals(0, w.getAttempt());
    assertEquals("TEST", w.getAnswer().toString());
    assertTrue(w.isLetterCorrect('t', 3));
    assertTrue(w.isLetterInAnswer('T'));
    w.addLetter('t');
    assertEquals("T", w.getGuess().toString());
    assertTrue(w.isLetterCorrect(w.getGuess().getCharAtIndex(0), 0));
    assertFalse(w.compareGuessToAnswer());
    w.addLetter('e');
    w.addLetter('s');
    w.addLetter('t');
    assertTrue(w.compareGuessToAnswer());
    w.removeLetter();
    assertEquals("TES", w.getGuess().toString());
    w.resetGuess();
    assertEquals("", w.getGuess().toString());
    w.addLetter('t');
    w.addLetter('e');
    w.addLetter('s');
    w.addLetter('s');
    int[] testArray = w.submitGuess();
    assertArrayEquals(new int[]{1, 1, 1, 0}, testArray);
    assertEquals("", w.getGuess().toString());
    assertEquals(1, w.getAttempt());
  }
}