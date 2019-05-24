package fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

  @DisplayName("こんにちは世界")
  @Test
  void testHelloWorld() {
    assertEquals("hello, world", FizzBuzz.greeting());
  }

}

