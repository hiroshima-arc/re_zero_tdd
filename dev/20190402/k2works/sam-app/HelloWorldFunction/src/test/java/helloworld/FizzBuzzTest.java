
package helloworld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FizzBuzzTest {
  @Test
  public void test1から100までをプリントする() {
      int[] list = FizzBuzz.print1To100();
      assertEquals(1, list[0]);
      assertEquals(100,list[99]);
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
