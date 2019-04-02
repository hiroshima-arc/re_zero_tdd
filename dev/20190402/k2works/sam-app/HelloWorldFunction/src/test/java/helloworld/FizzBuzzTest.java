
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
      FizzBuzz.print(list);
      }
  @Test
  public void test3で割り切れる場合はFizzをプリントする() {
      assertEquals("Fizz", FizzBuzz.generate(3));
      assertEquals("1", FizzBuzz.generate(1));
  }
  @Test
    public void test5で割り切れる場合はBuzzをプリントする() {
      assertEquals("Buzz", FizzBuzz.generate(5));
  }
  @Test
    public void test3と5で割り切れる場合はFizzBuzzをプリントする() {
      assertEquals("FizzBuzz", FizzBuzz.generate(15));
  }
}
