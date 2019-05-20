package k2works;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

  @DisplayName("値を1から100までプリントする")
  @Test
  void testPrint1To100() {
    int[] lint = FizzBuzz.printValue();
    assertEquals(1, lint[0]);
    assertEquals(100, lint[99]);
  }

}

