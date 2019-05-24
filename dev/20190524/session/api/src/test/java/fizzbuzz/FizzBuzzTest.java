package fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

  @DisplayName("1から100までをプリントする")
  @Test
  void test1To100() {
    assertEquals(1, FizzBuzz.print1To100());
  }

}

