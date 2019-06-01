package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
  private FizzBuzzValueCommand _fizzBuzzCommand;
  private FizzBuzzListCommand _fizzBuzzListCommand;

  @BeforeEach
  void init() {
    _fizzBuzzCommand = new FizzBuzzValueCommand(FizzBuzzType.one);
    _fizzBuzzListCommand = new FizzBuzzListCommand(FizzBuzzType.one);
  }

  @DisplayName(
    "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
  )
  @Test
  void testPrint1To100() {
    List<FizzBuzzValue> list = _fizzBuzzListCommand.execute(100).getList();
    assertEquals("1", list.get(0).getValue());
    assertEquals("Fizz", list.get(2).getValue());
    assertEquals("Buzz", list.get(4).getValue());
    assertEquals("FizzBuzz", list.get(14).getValue());
    assertEquals("Buzz", list.get(99).getValue());
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
    FizzBuzzListCommand fizzBuzz = new FizzBuzzListCommand(FizzBuzzType.one);
    List<FizzBuzzValue> list = fizzBuzz.execute(100).getList();
    assertEquals("Fizz", list.get(2).getValue());
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
    FizzBuzzListCommand fizzBuzz = new FizzBuzzListCommand(FizzBuzzType.two);
    List<FizzBuzzValue> list = fizzBuzz.execute(100).getList();
    assertEquals("3", list.get(2).getValue());
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
    FizzBuzzListCommand fizzBuzz = new FizzBuzzListCommand(FizzBuzzType.three);
    List<FizzBuzzValue> list = fizzBuzz.execute(100).getList();
    assertEquals("FizzBuzz", list.get(14).getValue());
    assertEquals("3", list.get(2).getValue());
  }

  @DisplayName("FizzBuzzValueはNullオブジェクトを返す")
  @Test
  void testFizzBuzzValueNull() {
    IFizzBuzz fizzBuzz = _fizzBuzzCommand.execute(3);
    List<FizzBuzzValue> list = fizzBuzz.getList();
    List<FizzBuzzValue> empty = new ArrayList<>();
    assertEquals(empty, list);
  }

  @DisplayName("FizzBuzzListはNullオブジェクトを返す")
  @Test
  void testFizzBuzzListNull() {
    IFizzBuzz list = _fizzBuzzListCommand.execute(100);
    assertEquals("", list.getValue());
  }

  @DisplayName("FizzBuzzValueの値は正の値のみ許可する")
  @Test
  void testFizzBuzzValueNumber() {
    Throwable exception = assertThrows(
      AssertionError.class,
      () -> {
        _fizzBuzzCommand.execute(-3);
      }
    );
    assertEquals(
      "FizzBuzzValue can't generate by minus number",
      exception.getMessage()
    );
  }

  @DisplayName("FizzBuzzListの値は正の値のみ許可する")
  @Test
  void testFizzBuzzListMinusNumber() {
    Throwable exception = assertThrows(
      AssertionError.class,
      () -> {
        _fizzBuzzListCommand.execute(-100);
      }
    );
    assertEquals(
      "FizzBuzzList can't generate by minus number",
      exception.getMessage()
    );
  }

  @DisplayName("FizzBuzzListは101以上を許可しない")
  @Test
  void testFizzBuzzListMaxNumber() {
    Throwable exception = assertThrows(
      AssertionError.class,
      () -> {
        _fizzBuzzListCommand.execute(101);
      }
    );
    assertEquals(
      "FizzBuzzList can't generate over 100",
      exception.getMessage()
    );
  }

}

