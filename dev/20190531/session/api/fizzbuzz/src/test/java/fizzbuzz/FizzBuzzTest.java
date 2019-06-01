package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _fizzBuzz;

  @BeforeEach
  void init() {
    _fizzBuzz = new FizzBuzz(FizzBuzzType.one);
  }

  @DisplayName(
    "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    _fizzBuzz.generateList();
    assertEquals("1", _fizzBuzz.getList().get(0).getValue());
    assertEquals("Fizz", _fizzBuzz.getList().get(2).getValue());
    assertEquals("Buzz", _fizzBuzz.getList().get(4).getValue());
    assertEquals("FizzBuzz", _fizzBuzz.getList().get(14).getValue());
    assertEquals("Buzz", _fizzBuzz.getList().get(99).getValue());
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", _fizzBuzz.generate(3).getValue());
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", _fizzBuzz.generate(5).getValue());
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", _fizzBuzz.generate(15).getValue());
  }

  @DisplayName("タイプ1は通常のパターンを返す")
  @Test
  void testType1() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assertEquals("Fizz", fizzBuzz.generate(3).getValue());
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1List() {
    _fizzBuzz.generateList();
    assertEquals("Fizz", _fizzBuzz.getList().get(2).getValue());
  }

  @DisplayName("タイプ2は数のみのパターンを返す")
  @Test
  void testType2() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    assertEquals("3", fizzBuzz.generate(3).getValue());
  }

  @DisplayName("タイプ2は数のみのパターンのリストを返す")
  @Test
  void testType2List() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    fizzBuzz.generateList();
    assertEquals("3", fizzBuzz.getList().get(2).getValue());
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンを値を返す")
  @Test
  void testType3() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    assertEquals("FizzBuzz", fizzBuzz.generate(15).getValue());
    assertEquals("3", fizzBuzz.generate(3).getValue());
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3List() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    fizzBuzz.generateList();
    assertEquals("FizzBuzz", fizzBuzz.getList().get(14).getValue());
    assertEquals("3", fizzBuzz.getList().get(2).getValue());
  }

}

