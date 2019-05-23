package k2works;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
  private FizzBuzz _type01;
  private FizzBuzz _type02;
  private FizzBuzz _type03;
  private IFizzBuzzCommand _type01Command;
  private IFizzBuzzCommand _type02Command;
  private IFizzBuzzCommand _type03Command;

  @BeforeEach
  void init() {
    _type01 = new FizzBuzz(FizzBuzzType.one);
    _type02 = new FizzBuzz(FizzBuzzType.two);
    _type03 = new FizzBuzz(FizzBuzzType.three);
    _type01Command = new FizzBuzzValueCommand(FizzBuzzType.one);
    _type02Command = new FizzBuzzValueCommand(FizzBuzzType.two);
    _type03Command = new FizzBuzzValueCommand(FizzBuzzType.three);
  }

  @DisplayName(
    "値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    FizzBuzzValues list = _type01.generateList();
    assertEquals("1", list.getValues().get(0).getValue());
    assertEquals("Buzz", list.getValues().get(99).getValue());
  }

  @DisplayName("3で割り切れる場合はFizzをプリントする")
  @Test
  void testFizz() {
    assertEquals("Fizz", _type01Command.execute(3).getValue());
  }

  @DisplayName("5で割り切れる場合はBuzzをプリントする")
  @Test
  void testBuzz() {
    assertEquals("Buzz", _type01Command.execute(5).getValue());
  }

  @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
  @Test
  void testFizzBuzz() {
    assertEquals("FizzBuzz", _type01Command.execute(15).getValue());
  }

  @DisplayName("タイプ1は通常のパターンの値を返す")
  @Test
  void testType1() {
    IFizzBuzzCommand command = new FizzBuzzValueCommand(FizzBuzzType.one);
    assertEquals("Fizz", command.execute(3).getValue());
  }

  @DisplayName("タイプ1は通常のパターンのリストを返す")
  @Test
  void testType1Valuse() {
    FizzBuzz type01 = new FizzBuzz(FizzBuzzType.one);
    FizzBuzzValues list = type01.generateList();
    assertEquals("Fizz", list.getValues().get(2).getValue());
  }

  @DisplayName("タイプ2は数字のみのパターンの値を返す")
  @Test
  void testType2() {
    assertEquals("3", _type02Command.execute(3).getValue());
  }

  @DisplayName("タイプ2は数字のみのパターンのリストを返す")
  @Test
  void testType2Valuse() {
    _type02.generateList();
    FizzBuzzValues list = _type02.generateList();
    assertEquals("3", list.getValues().get(2).getValue());
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
  @Test
  void testType3() {
    assertEquals("FizzBuzz", _type03Command.execute(15).getValue());
    assertEquals("3", _type03Command.execute(3).getValue());
  }

  @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す")
  @Test
  void testType3Valuse() {
    _type03.generateList();
    FizzBuzzValues list = _type03.generateList();
    assertEquals("FizzBuzz", list.getValues().get(14).getValue());
    assertEquals("3", list.getValues().get(2).getValue());
  }

}

