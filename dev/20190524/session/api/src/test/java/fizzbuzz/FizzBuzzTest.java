package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _fizzBuzz;

  @BeforeEach
  void innit() {
    _fizzBuzz = new FizzBuzz();
  }

  @DisplayName(
    "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void test1To100() {
    _fizzBuzz.generateList();
    assertEquals("1", _fizzBuzz.getList().get(0));
    assertEquals("Fizz", _fizzBuzz.getList().get(2));
    assertEquals("Buzz", _fizzBuzz.getList().get(4));
    assertEquals("FizzBuzz", _fizzBuzz.getList().get(14));
    assertEquals("Buzz", _fizzBuzz.getList().get(99));
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", _fizzBuzz.generate(3, 1));
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", _fizzBuzz.generate(5, 1));
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", _fizzBuzz.generate(15, 1));
  }

  @DisplayName("タイプ1は通常のパターンを返す")
  @Test
  void testType1() {
    assertEquals("Fizz", _fizzBuzz.generate(3, 1));
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1List() {
    _fizzBuzz.generateList(1);
    assertEquals("Fizz", _fizzBuzz.getList().get(2));
  }

  @DisplayName("タイプ2は数のみのパターンを値を返す")
  @Test
  void testType2() {
    assertEquals("3", _fizzBuzz.generate(3, 2));
  }

  @DisplayName("タイプ2は数のみのパターンのリストを返す")
  @Test
  void testType2List() {
    _fizzBuzz.generateList(2);
    assertEquals("3", _fizzBuzz.getList().get(2));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
  @Test
  void testType3() {
    assertEquals("FizzBuzz", _fizzBuzz.generate(15, 3));
    assertEquals("3", _fizzBuzz.generate(3, 3));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3Value() {
    _fizzBuzz.generateList(3);
    assertEquals("FizzBuzz", _fizzBuzz.getList().get(14));
    assertEquals("3", _fizzBuzz.getList().get(2));
  }

}

