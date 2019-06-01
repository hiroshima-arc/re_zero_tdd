package fizzbuzz.domain.service;

import fizzbuzz.application.command.FizzBuzzValueCommand;
import fizzbuzz.application.service.FizzBuzzService;
import fizzbuzz.application.service.IFizzBuzz;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
  private FizzBuzzService _fizzBuzzService;

  @BeforeEach
  void init() {
    _fizzBuzzService = new FizzBuzzService();
  }

  @DisplayName("通常パターン")
  @Nested
  class WhenNormal {

    @DisplayName(
      "1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする"
    )
    @Test
    void testPrint1To100() {
      IFizzBuzz list = _fizzBuzzService.generateList(FizzBuzzType.one, 100);
      assertEquals("1", list.getList().get(0).getValue());
      assertEquals("Fizz", list.getList().get(2).getValue());
      assertEquals("Buzz", list.getList().get(4).getValue());
      assertEquals("FizzBuzz", list.getList().get(14).getValue());
      assertEquals("Buzz", list.getList().get(99).getValue());
    }

    @DisplayName("3で割り切れる場合はFizzをプリントする")
    @Test
    void testFizz() {
      assertEquals(
        "Fizz",
        _fizzBuzzService.generate(FizzBuzzType.one, 3).getValue()
      );
    }

    @DisplayName("5で割り切れる場合はBuzzをプリントする")
    @Test
    void testBuzz() {
      assertEquals(
        "Buzz",
        _fizzBuzzService.generate(FizzBuzzType.one, 5).getValue()
      );
    }

    @DisplayName("15で割り切れる場合はFizzBuzzをプリントする")
    @Test
    void testFizzBuzz() {
      assertEquals(
        "FizzBuzz",
        _fizzBuzzService.generate(FizzBuzzType.one, 15).getValue()
      );
    }

    @DisplayName("タイプ1は通常のパターンを返す")
    @Test
    void testType1() {
      assertEquals(
        "Fizz",
        _fizzBuzzService.generate(FizzBuzzType.one, 3).getValue()
      );
    }

    @DisplayName("タイプ1は通常のパターンのリストを返す")
    @Test
    void testType1List() {
      IFizzBuzz list = _fizzBuzzService.generateList(FizzBuzzType.one, 100);
      assertEquals("Fizz", list.getList().get(2).getValue());
    }

    @DisplayName("タイプ2は数のみのパターンを返す")
    @Test
    void testType2() {
      assertEquals(
        "3",
        _fizzBuzzService.generate(FizzBuzzType.two, 3).getValue()
      );
    }

    @DisplayName("タイプ2は数のみのパターンのリストを返す")
    @Test
    void testType2List() {
      IFizzBuzz list = _fizzBuzzService.generateList(FizzBuzzType.two, 100);
      assertEquals("3", list.getList().get(2).getValue());
    }

    @DisplayName("タイプ3は15で割り切れる場合にFizzBuzzのパターンを値を返す")
    @Test
    void testType3() {
      FizzBuzzValueCommand fizzBuzz = new FizzBuzzValueCommand(
        FizzBuzzType.three
      );
      assertEquals(
        "FizzBuzz",
        _fizzBuzzService.generate(FizzBuzzType.three, 15).getValue()
      );
      assertEquals(
        "3",
        _fizzBuzzService.generate(FizzBuzzType.three, 3).getValue()
      );
    }

    @DisplayName(
      "タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す"
    )
    @Test
    void testType3List() {
      IFizzBuzz list = _fizzBuzzService.generateList(FizzBuzzType.three, 100);
      assertEquals("FizzBuzz", list.getList().get(14).getValue());
      assertEquals("3", list.getList().get(2).getValue());
    }

  }

  @DisplayName("例外パターン")
  @Nested
  class WhenException {

    @DisplayName("FizzBuzzValueはNullオブジェクトを返す")
    @Test
    void testFizzBuzzValueNull() {
      IFizzBuzz fizzBuzz = _fizzBuzzService.generate(FizzBuzzType.one, 3);
      List<FizzBuzzValue> list = fizzBuzz.getList();
      List<FizzBuzzValue> empty = new ArrayList<>();
      assertEquals(empty, list);
    }

    @DisplayName("FizzBuzzListはNullオブジェクトを返す")
    @Test
    void testFizzBuzzListNull() {
      IFizzBuzz list = _fizzBuzzService.generateList(FizzBuzzType.one, 100);
      assertEquals("", list.getValue());
    }

    @DisplayName("FizzBuzzValueの値は正の値のみ許可する")
    @Test
    void testFizzBuzzValueNumber() {
      Throwable exception = assertThrows(
        IllegalArgumentException.class,
        () -> {
          _fizzBuzzService.generate(FizzBuzzType.one, -3);
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
        IllegalArgumentException.class,
        () -> {
          _fizzBuzzService.generateList(FizzBuzzType.one, -100);
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
        IllegalArgumentException.class,
        () -> {
          _fizzBuzzService.generateList(FizzBuzzType.one, 101);
        }
      );
      assertEquals(
        "FizzBuzzList can't generate over 100",
        exception.getMessage()
      );
    }

  }

}

