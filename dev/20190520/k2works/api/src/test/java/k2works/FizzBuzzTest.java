package k2works;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _type01;
  private FizzBuzz _type02;
  private FizzBuzz _type03;

  @BeforeEach
  void init() {
    _type01 = new FizzBuzz(FizzBuzzType.one);
    _type02 = new FizzBuzz(FizzBuzzType.two);
    _type03 = new FizzBuzz(FizzBuzzType.three);
  }

  @DisplayName(
    "値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    _type01.generateList();
    assertEquals("1", _type01.getValuse().get(0));
    assertEquals("Buzz", _type01.getValuse().get(99));
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", _type01.generate(3));
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", _type01.generate(5));
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", _type01.generate(15));
  }

  @DisplayName("タイプ1は通常のパターンの値を返す")
  @Test
  void testType1() {
    FizzBuzz type01 = new FizzBuzz(FizzBuzzType.one);
    assertEquals("Fizz", type01.generate(3));
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1Valuse() {
    FizzBuzz type01 = new FizzBuzz(FizzBuzzType.one);
    type01.generateList();
    assertEquals("Fizz", type01.getValuse().get(2));
  }

  @DisplayName("タイプ2は数字のみのパターンの値を返す")
  @Test
  void testType2() {
    assertEquals("3", _type02.generate(3));
  }

  @DisplayName("タイプ2は数字のみのパターンのリストを返す")
  @Test
  void testType2Valuse() {
    _type02.generateList();
    assertEquals("3", _type02.getValuse().get(2));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
  @Test
  void testType3() {
    assertEquals("FizzBuzz", _type03.generate(15));
    assertEquals("3", _type03.generate(3));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3Valuse() {
    _type03.generateList();
    assertEquals("FizzBuzz", _type03.getValuse().get(14));
    assertEquals("3", _type03.getValuse().get(2));
  }

}

