package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _fizzBuzz;
  private FizzBuzzValueCommand _fizzBuzzCommand;

  @BeforeEach
  void init() {
    _fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    _fizzBuzzCommand = new FizzBuzzValueCommand(FizzBuzzType.one);
  }

  @DisplayName(
    "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    _fizzBuzz.generateList();
    assertEquals("1", _fizzBuzz.generateList().getList().get(0).getValue());
    assertEquals("Fizz", _fizzBuzz.generateList().getList().get(2).getValue());
    assertEquals("Buzz", _fizzBuzz.generateList().getList().get(4).getValue());
    assertEquals(
      "FizzBuzz",
      _fizzBuzz.generateList().getList().get(14).getValue()
    );
    assertEquals("Buzz", _fizzBuzz.generateList().getList().get(99).getValue());
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", _fizzBuzzCommand.execute(3).getValue());
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", _fizzBuzzCommand.execute(5).getValue());
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", _fizzBuzzCommand.execute(15).getValue());
  }

  @DisplayName("タイプ1は通常のパターンを返す")
  @Test
  void testType1() {
    FizzBuzzValueCommand fizzBuzz = new FizzBuzzValueCommand(FizzBuzzType.one);
    assertEquals("Fizz", fizzBuzz.execute(3).getValue());
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1List() {
    _fizzBuzz.generateList();
    assertEquals("Fizz", _fizzBuzz.generateList().getList().get(2).getValue());
  }

  @DisplayName("タイプ2は数のみのパターンを返す")
  @Test
  void testType2() {
    FizzBuzzValueCommand fizzBuzz = new FizzBuzzValueCommand(FizzBuzzType.two);
    assertEquals("3", fizzBuzz.execute(3).getValue());
  }

  @DisplayName("タイプ2は数のみのパターンのリストを返す")
  @Test
  void testType2List() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    fizzBuzz.generateList();
    assertEquals("3", fizzBuzz.generateList().getList().get(2).getValue());
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンを値を返す")
  @Test
  void testType3() {
    FizzBuzzValueCommand fizzBuzz = new FizzBuzzValueCommand(
      FizzBuzzType.three
    );
    assertEquals("FizzBuzz", fizzBuzz.execute(15).getValue());
    assertEquals("3", fizzBuzz.execute(3).getValue());
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3List() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    fizzBuzz.generateList();
    assertEquals(
      "FizzBuzz",
      fizzBuzz.generateList().getList().get(14).getValue()
    );
    assertEquals("3", fizzBuzz.generateList().getList().get(2).getValue());
  }

}

