package k2works;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

  @DisplayName(
    "値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    List<String> list = FizzBuzz.generateList();
    assertEquals("1", list.get(0));
    assertEquals("Buzz", list.get(99));
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", FizzBuzz.generate(3));
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", FizzBuzz.generate(5));
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", FizzBuzz.generate(15));
  }

}
