package fizzbuzz;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzzData _data;

  @BeforeEach
  void init() {
    _data = new FizzBuzzData();
  }

  @DisplayName(
    "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    List<String> list = FizzBuzz.generateList();
    _data.list = list;
    assertEquals("1", _data.list.get(0));
    assertEquals("Fizz", _data.list.get(2));
    assertEquals("Buzz", _data.list.get(4));
    assertEquals("FizzBuzz", _data.list.get(14));
    assertEquals("Buzz", _data.list.get(99));
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
    _data.list = FizzBuzz.generateList(1);
    assertEquals("Fizz", _data.list.get(2));
  }

  @DisplayName("タイプ2は数のみのパターンを返す")
  @Test
  void testType2() {
    assertEquals("3", FizzBuzz.generate(3, 2));
  }

}

