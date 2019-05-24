package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzzData _data;

  @BeforeEach
  void innit() {
    _data = new FizzBuzzData();
  }

  @DisplayName(
    "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void test1To100() {
    List<String> list = FizzBuzz.generateList();
    _data.setList(list);
    assertEquals("1", _data.getList().get(0));
    assertEquals("Fizz", _data.getList().get(2));
    assertEquals("Buzz", _data.getList().get(4));
    assertEquals("FizzBuzz", _data.getList().get(14));
    assertEquals("Buzz", _data.getList().get(99));
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

  @DisplayName("タイプ1は通常のパターンを返す")
  @Test
  void testType1() {
    assertEquals("Fizz", FizzBuzz.generate(3, 1));
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1List() {
    _data.setList(FizzBuzz.generateList(1));
    assertEquals("Fizz", _data.getList().get(2));
  }

  @DisplayName("タイプ2は数のみのパターンを値を返す")
  @Test
  void testType2() {
    assertEquals("3", FizzBuzz.generate(3, 2));
  }

  @DisplayName("タイプ2は数のみのパターンのリストを返す")
  @Test
  void testType2List() {
    _data.setList(FizzBuzz.generateList(2));
    assertEquals("3", _data.getList().get(2));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
  @Test
  void testType3() {
    assertEquals("FizzBuzz", FizzBuzz.generate(15, 3));
    assertEquals("3", FizzBuzz.generate(3, 3));
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3Value() {
    _data.setList(FizzBuzz.generateList(3));
    assertEquals("FizzBuzz", _data.getList().get(14));
    assertEquals("3", _data.getList().get(2));
  }

}

