package k2works.application.service;

import java.util.ArrayList;
import java.util.List;

import k2works.domain.model.FizzBuzzValue;
import k2works.domain.type.FizzBuzzType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzServiceTest {
  private IFizzBuzzCommand _type01Command;
  private IFizzBuzzCommand _type02Command;
  private IFizzBuzzCommand _type03Command;

  @BeforeEach
  void init() {
    _type01Command = new FizzBuzzValueCommand(FizzBuzzType.one);
    _type02Command = new FizzBuzzValueCommand(FizzBuzzType.two);
    _type03Command = new FizzBuzzValueCommand(FizzBuzzType.three);
  }

  @DisplayName("通常パターン")
  @Nested
  class WhenNormal {

    @DisplayName(
      "値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
    )
    @Test
    void testPrint1To100() {
      IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.one);
      IFizzBuzz list = command.execute(100);
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

  }

  @DisplayName("タイプ1")
  @Nested
  class WhenType1 {

    @DisplayName("タイプ1は通常のパターンの値を返す")
    @Test
    void testType1() {
      IFizzBuzzCommand command = new FizzBuzzValueCommand(FizzBuzzType.one);
      assertEquals("Fizz", command.execute(3).getValue());
    }

    @DisplayName("タイプ1は通常のパターンのリストを返す")
    @Test
    void testType1Values() {
      IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.one);
      IFizzBuzz list = command.execute(100);
      assertEquals("Fizz", list.getValues().get(2).getValue());
    }

  }

  @DisplayName("タイプ2")
  @Nested
  class WhenType2 {

    @DisplayName("タイプ2は数字のみのパターンの値を返す")
    @Test
    void testType2() {
      assertEquals("3", _type02Command.execute(3).getValue());
    }

    @DisplayName("タイプ2は数字のみのパターンのリストを返す")
    @Test
    void testType2Values() {
      IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.two);
      IFizzBuzz list = command.execute(100);
      assertEquals("3", list.getValues().get(2).getValue());
    }

  }

  @DisplayName("タイプ3")
  @Nested
  class WhenType3 {

    @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンの値を返す")
    @Test
    void testType3() {
      assertEquals("FizzBuzz", _type03Command.execute(15).getValue());
      assertEquals("3", _type03Command.execute(3).getValue());
    }

    @DisplayName(
      "タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す"
    )
    @Test
    void testType3Values() {
      IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.three);
      IFizzBuzz list = command.execute(100);
      assertEquals("FizzBuzz", list.getValues().get(14).getValue());
      assertEquals("3", list.getValues().get(2).getValue());
    }

  }

  @DisplayName("例外パターン")
  @Nested
  class WhenException {

    @DisplayName("FizzBuzzValueはNullオブジェクトを返す")
    @Test
    void testFizzBuzzValueNull() {
      IFizzBuzz fizzBuzz = _type01Command.execute(3);
      List<FizzBuzzValue> empty = new ArrayList<>();
      List<FizzBuzzValue> values = fizzBuzz.getValues();
      assertEquals(empty, values);
    }

    @DisplayName("FizzBuzzValuesはNullオブジェクトを返す")
    @Test
    void testFizzBuzzValuesNull() {
      IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.one);
      IFizzBuzz list = command.execute(100);
      assertEquals("", list.getValue());
    }

    @DisplayName("FizzBuzzValueの値は正の値のみ許可する")
    @Test
    void testFizzBuzzValueNumber() {
      Throwable exception = assertThrows(
        IllegalArgumentException.class,
        () -> {
          _type01Command.execute(-3);
        }
      );
      assertEquals(
        "FizzBuzzValue can't generate by minus number",
        exception.getMessage()
      );
    }

    @DisplayName("FizzBuzzValuesは101以上を許可しない")
    @Test
    void testFizzBuzzValuesNumber() {
      Throwable exception = assertThrows(
        IllegalArgumentException.class,
        () -> {
          IFizzBuzzCommand command = new FizzBuzzValuesCommand(
            FizzBuzzType.one
          );
          command.execute(101);
        }
      );
      assertEquals(
        "FizzBuzzValues can't generate over 100",
        exception.getMessage()
      );
    }

  }

}

