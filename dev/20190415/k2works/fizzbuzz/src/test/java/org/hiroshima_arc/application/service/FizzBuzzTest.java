package org.hiroshima_arc.application.service;

import org.hiroshima_arc.application.service.fizzbuzz.FizzBuzzValueService;
import org.hiroshima_arc.application.service.fizzbuzz.FizzBuzzValuesService;
import org.hiroshima_arc.application.service.fizzbuzz.IFizzBuzzService;
import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;
import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;
import org.hiroshima_arc.domain.type.fizzbuzz.FizzBuzzType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private IFizzBuzz _fizzBuzz;
    private IFizzBuzzService _fizzBuzzValueService;
    private IFizzBuzzService _fizzBuzzValuesService;

    @BeforeEach
    void init() {
        _fizzBuzzValueService = new FizzBuzzValueService(FizzBuzzType.valueOf("one"));
        _fizzBuzzValuesService = new FizzBuzzValuesService(FizzBuzzType.valueOf("one"));
    }

    @Nested
    @DisplayName("通常パターン")
    class WhenNormal {
        @Test
        @DisplayName("値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする")
        void testPrintValue() {
            _fizzBuzz = _fizzBuzzValuesService.execute(100);
            assertEquals("1", _fizzBuzz.getValues().get(0).getValue());
            assertEquals("Fizz", _fizzBuzz.getValues().get(2).getValue());
            assertEquals("Buzz", _fizzBuzz.getValues().get(4).getValue());
            assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14).getValue());
            assertEquals("Buzz", _fizzBuzz.getValues().get(99).getValue());
        }

        @Test
        @DisplayName("値が3で割り切れる場合はFizzをプリントする")
        void testGenerateFizz() {
            _fizzBuzz = _fizzBuzzValueService.execute(3);
            assertEquals("Fizz", _fizzBuzz.getValue());
        }

        @Test
        @DisplayName("値が5で割り切れる場合はBuzzをプリントする")
        void testGenerateBuzz() {
            _fizzBuzz = _fizzBuzzValueService.execute(5);
            assertEquals("Buzz", _fizzBuzz.getValue());
        }

        @Test
        @DisplayName("値が3と5で割り切れる場合はFizzBuzzをプリントする")
        void testGenerateFizzBuzz() {
            _fizzBuzz = _fizzBuzzValueService.execute(15);
            assertEquals("FizzBuzz", _fizzBuzz.getValue());
        }
    }

    @Nested
    @DisplayName("タイプ1の場合")
    class WhenType1 {
        @Test
        @DisplayName("タイプ1は通常のパターンを返す")
        void testType1Value() {
            IFizzBuzzService service = new FizzBuzzValueService(FizzBuzzType.valueOf("one"));
            _fizzBuzz = service.execute(3);
            assertEquals("Fizz", _fizzBuzz.getValue());
        }

        @Test
        @DisplayName("タイプ1は通常のパターンを返す")
        void testType1Values() {
            IFizzBuzzService service = new FizzBuzzValuesService(FizzBuzzType.valueOf("one"));
            _fizzBuzz = service.execute(3);
            assertEquals("Fizz", _fizzBuzz.getValues().get(2).getValue());
        }
    }
    @Nested
    @DisplayName("タイプ2の場合")
    class WhenType2 {
        @Test
        @DisplayName("タイプ2は数字のみのパターンを返す")
        void testType2Value() {
            IFizzBuzzService service = new FizzBuzzValueService(FizzBuzzType.valueOf("two"));
            _fizzBuzz = service.execute(3);
            assertEquals("3", _fizzBuzz.getValue());
        }

        @Test
        @DisplayName("タイプ2は数字のみのパターンを返す")
        void testType2Values() {
            IFizzBuzzService service = new FizzBuzzValuesService(FizzBuzzType.valueOf("two"));
            _fizzBuzz = service.execute(3);
            assertEquals("3", _fizzBuzz.getValues().get(2).getValue());
        }
    }

    @Nested
    @DisplayName("タイプ3の場合")
    class WhenType3 {
        @Test
        @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
        void testType3Value() {
            IFizzBuzzService service = new FizzBuzzValueService(FizzBuzzType.valueOf("three"));
            _fizzBuzz = service.execute(3);
            assertEquals("3", _fizzBuzz.getValue());
            _fizzBuzz = service.execute(15);
            assertEquals("FizzBuzz", _fizzBuzz.getValue());
        }

        @Test
        @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
        void testType3Values() {
            IFizzBuzzService service = new FizzBuzzValuesService(FizzBuzzType.valueOf("three"));
            _fizzBuzz = service.execute(3);
            assertEquals("3", _fizzBuzz.getValues().get(2).getValue());
            _fizzBuzz = service.execute(15);
            assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14).getValue());
        }
    }

    @Nested
    @DisplayName("例外パターン")
    class WhenException {
        @Test
        @DisplayName("FizzBuzzValueはNullオブジェクトを返す")
        void testFizzBuzzValueNull() {
            _fizzBuzz = _fizzBuzzValueService.execute(3);
            List<FizzBuzzValue> values =_fizzBuzz.getValues();
            assertEquals("", values.get(0).getValue());
        }

        @Test
        @DisplayName("FizzBuzzValuesはNullオブジェクトを返す")
        void testFizzBuzzValuesNull() {
            _fizzBuzz = _fizzBuzzValuesService.execute(3);
            String value =_fizzBuzz.getValue();
            assertEquals("", value);
        }

        @Test
        @DisplayName("FizzBuzzValueの値は正の値のみ許可する")
        void testFizzBuzzValueNumber() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                _fizzBuzzValueService.execute(-3);
            });
            assertEquals("FizzBuzzValue can't generate minus number", exception.getMessage());
        }

        @Test
        @DisplayName("FizzBuzzValuesは101以上を許可しない")
        void testFizzBuzzValuesNumber() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                _fizzBuzzValuesService.execute(101);
            });
            assertEquals("FizzBuzzValues can't generate over 100", exception.getMessage());
        }
    }
}
