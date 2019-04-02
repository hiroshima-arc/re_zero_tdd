
package helloworld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzzData _fizzBuzzData;
  @BeforeEach
  void init() {
      _fizzBuzzData = new FizzBuzzData();
  }

  @Test
  public void test1から100までをプリントする() {
      _fizzBuzzData.setValues(FizzBuzz.generateFizzBuzzList());
      assertEquals("1", FizzBuzz.generateFizzBuzzList().get(0));
      assertEquals("Fizz", _fizzBuzzData.getValues().get(2));
      assertEquals("Buzz", _fizzBuzzData.getValues().get(4));
      assertEquals("FizzBuzz", _fizzBuzzData.getValues().get(14));
      assertEquals("Buzz",_fizzBuzzData.getValues().get(99));
      FizzBuzz.print(_fizzBuzzData.getValues());
      }
  @Test
  public void test3で割り切れる場合はFizzをプリントする() {
      _fizzBuzzData.setValue(FizzBuzz.generate(3));
      assertEquals("Fizz", _fizzBuzzData.getValue());
      _fizzBuzzData.setValue(FizzBuzz.generate(1));
      assertEquals("1", _fizzBuzzData.getValue());
  }
  @Test
    public void test5で割り切れる場合はBuzzをプリントする() {
      _fizzBuzzData.setValue(FizzBuzz.generate(5));
      assertEquals("Buzz", _fizzBuzzData.getValue());
  }
  @Test
    public void test3と5で割り切れる場合はFizzBuzzをプリントする() {
      _fizzBuzzData.setValue(FizzBuzz.generate(15));
      assertEquals("FizzBuzz", _fizzBuzzData.getValue());
  }
  @Test
    public void タイプ1は通常のパターンを返す() {
      assertEquals("Fizz", FizzBuzz.generate(3, 1));
  }
}
