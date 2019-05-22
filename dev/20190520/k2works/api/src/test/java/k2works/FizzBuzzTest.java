package k2works;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _fizzBuzz;

  @BeforeEach
  void init() {
    _fizzBuzz = new FizzBuzz();
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

  @DisplayName("タイプ1は通常のパターンの値を返す")
  @Test
  void testType1() {
    assertEquals("Fizz", FizzBuzz.generate(3, 1));
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1Valuse() {
    _fizzBuzz.generateList(1);
    assertEquals("Fizz", _fizzBuzz.getValuse().get(2));
  }

  @DisplayName("タイプ2は数字のみのパターンの値を返す")
  @Test
  void testType2() {
    assertEquals("3", FizzBuzz.generate(3, 2));
  }

  @DisplayName("タイプ2は数字のみのパターンのリストを返す")
  @Test
  void testType2Valuse() {
    _fizzBuzz.generateList(2);
    assertEquals("3", _fizzBuzz.getValuse().get(2));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
  @Test
  void testType3() {
    assertEquals("FizzBuzz", FizzBuzz.generate(15, 3));
    assertEquals("3", FizzBuzz.generate(3, 3));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3Valuse() {
    _fizzBuzz.generateList(3);
    assertEquals("FizzBuzz", _fizzBuzz.getValuse().get(14));
    assertEquals("3", _fizzBuzz.getValuse().get(2));
  }

}

