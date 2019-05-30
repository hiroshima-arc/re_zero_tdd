package fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

  @DisplayName("1から100までをプリントする")
  @Test
  void testPrint1To100() {
    int[] list = FizzBuzz.print1To100();
    assertEquals(1, list[0]);
    assertEquals(100, list[99]);
  }

}

