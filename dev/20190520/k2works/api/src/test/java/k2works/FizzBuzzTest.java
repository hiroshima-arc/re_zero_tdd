package k2works;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _fizzBuzz;

  @BeforeEach
  void init() {
    _fizzBuzz = new FizzBuzz(new FizzBuzzType01());
  }

  @DisplayName(
    "値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    _fizzBuzz.generateList();
    assertEquals("1", _fizzBuzz.getValuse().get(0));
    assertEquals("Buzz", _fizzBuzz.getValuse().get(99));
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", _fizzBuzz.generate(3));
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", _fizzBuzz.generate(5));
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", _fizzBuzz.generate(15));
  }

  @DisplayName("タイプ1は通常のパターンの値を返す")
  @Test
  void testType1() {
    FizzBuzz type01 = new FizzBuzz(new FizzBuzzType01());
    assertEquals("Fizz", type01.generate(3));
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1Valuse() {
    FizzBuzz type01 = new FizzBuzz(new FizzBuzzType01());
    type01.generateList();
    assertEquals("Fizz", type01.getValuse().get(2));
  }

  @DisplayName("タイプ2は数字のみのパターンの値を返す")
  @Test
  void testType2() {
    FizzBuzz type02 = new FizzBuzz(new FizzBuzzType02());
    assertEquals("3", type02.generate(3));
  }

  @DisplayName("タイプ2は数字のみのパターンのリストを返す")
  @Test
  void testType2Valuse() {
    FizzBuzz type02 = new FizzBuzz(new FizzBuzzType02());
    type02.generateList();
    assertEquals("3", type02.getValuse().get(2));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
  @Test
  void testType3() {
    FizzBuzz type03 = new FizzBuzz(new FizzBuzzType03());
    assertEquals("FizzBuzz", type03.generate(15));
    assertEquals("3", type03.generate(3));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3Valuse() {
    FizzBuzz type03 = new FizzBuzz(new FizzBuzzType03());
    type03.generateList();
    assertEquals("FizzBuzz", type03.getValuse().get(14));
    assertEquals("3", type03.getValuse().get(2));
  }

}

