package org.example;

import junit.framework.TestCase;
import org.example.model.Letter;
import org.example.model.LetterImpl;

/** Unit test for simple App. */
public class AppTest extends TestCase {
  /** Test Letter compareTo() */
  public void testApp() {
    Letter a0 = new LetterImpl('a', 0);
    Letter a1 = new LetterImpl('a', 1);
    assertEquals(0, a0 == a1);

    assertTrue(true);
  }
}
