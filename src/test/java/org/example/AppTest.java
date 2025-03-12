package org.example;

import junit.framework.TestCase;
import org.example.model.Letter;
import org.example.model.LetterImpl;
import org.example.model.Word;
import org.example.model.WordImpl;

/** Unit test for simple App. */
@SuppressWarnings({"ReassignedVariable", "UnusedAssignment", "unused", "DataFlowIssue"})
public class AppTest extends TestCase {
  /** Test Letter constructors */
  public void testLetterConstructor() {
    // Test constructor for "space" char.
    boolean exception = false;
    try {
      Letter test = new LetterImpl(' ', 0);
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {
    }
    assertTrue(exception);

    // Test constructor for number char.
    exception = false;
    try {
      Letter test = new LetterImpl('1', 0);
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {
    }
    assertTrue(exception);

    // Test constructor for negative index.
    exception = false;
    try {
      Letter test = new LetterImpl('a', -1);
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {
    }
    assertTrue(exception);

    // Test constructor correct use.
    exception = false;
    try {
      Letter test = new LetterImpl('a', 0);
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {
    }
    assertFalse(exception);
  }

  /** Test Letter methods */
  public void testLetterMethods() {
    Letter a0 = new LetterImpl('a', 0);
    assertEquals('A', a0.getLetter());
    assertFalse('B' == a0.getLetter());
    assertEquals(0, a0.getIndex());
    assertFalse(1 == a0.getIndex());
  }

  /** Test Letter compareTo() */
  public void testLetterCompareTo() {
    // Testing equal letter and index.
    Letter a0 = new LetterImpl('a', 0);
    Letter a0_1 = new LetterImpl('a', 0);
    assertEquals(1, a0.compareTo(a0_1));

    // Testing equal letter.
    Letter a1 = new LetterImpl('a', 1);
    assertEquals(0, a0.compareTo(a1));

    // Testing equal index.
    Letter b0 = new LetterImpl('b', 0);
    assertEquals(-1, a0.compareTo(b0));

    // Testing different letter and index.
    Letter b1 = new LetterImpl('b', 1);
    assertEquals(-1, a0.compareTo(b1));
  }

  /** Test Word constructors */
  public void testWordConstructor() {
    boolean exception = false;
    Word w;
    try {
      w = new WordImpl("abc");
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {}
    assertFalse(exception);

    exception = false;
    Letter[] letterArray = new Letter[3];
    letterArray[0] = new LetterImpl('a', 0);
    letterArray[1] = new LetterImpl('b', 1);
    letterArray[2] = new LetterImpl('c', 2);
    try {
      w = new WordImpl(letterArray);
    } catch (IllegalArgumentException iae) {
      exception = true;
    } catch (Exception ignored) {}
    assertFalse(exception);
  }

  /** Test Word methods */
  public void testWordMethods() {
    Word w = new WordImpl("test");
    assertEquals(4, w.getLength());
    assertEquals('T', w.getLetterAtIndex(0));
    assertEquals('E', w.getLetterAtIndex(1));
    assertEquals('S', w.getLetterAtIndex(2));
    assertEquals('T', w.getLetterAtIndex(3));
  }

  /** Test Word compareTo */
  public void testWordCompareTo() {
    Word w = new WordImpl("test");
    Letter[] letterArray = new Letter[4];
    letterArray[0] = new LetterImpl('t', 0);
    letterArray[1] = new LetterImpl('e', 1);
    letterArray[2] = new LetterImpl('s', 2);
    letterArray[3] = new LetterImpl('t', 3);
    Word x = new WordImpl(letterArray);
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
}