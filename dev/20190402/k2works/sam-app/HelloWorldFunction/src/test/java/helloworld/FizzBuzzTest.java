
package helloworld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {
  @Test
  public void test1から100までをプリントする() {
      List<String> list = FizzBuzz.generateFizzBuzzList();
      assertEquals("1", list.get(0));
      assertEquals("Fizz", list.get(2));
      assertEquals("Buzz", list.get(4));
      assertEquals("FizzBuzz", list.get(14));
      assertEquals("Buzz",list.get(99));
      }
  @Test
  public void test3で割り切れる場合はFizzをプリントする() {
      assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
      assertEquals("1", FizzBuzz.fizzBuzz(1));
  }
  @Test
    public void test5で割り切れる場合はBuzzをプリントする() {
      assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
  }
  @Test
    public void test3と5で割り切れる場合はFizzBuzzをプリントする() {
      assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
  }
}
