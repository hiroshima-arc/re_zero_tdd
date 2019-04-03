
package fizzbuzz;

import fizzbuzz.application.FizzBuzzValueCommand;
import fizzbuzz.application.FizzBuzzValuesCommand;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.model.FizzBuzzValues;
import fizzbuzz.domain.type.FizzBuzzType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
    private FizzBuzzValueCommand _fizzBuzzValueCommand;
    private FizzBuzzValuesCommand _fizzBuzzValuesCommand;

    @BeforeEach
    void init() {
        _fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("one"));
        _fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("one"));
    }

    @Test
    public void 値を1から100までをプリントする() {
        FizzBuzzValues values = (FizzBuzzValues) _fizzBuzzValuesCommand.execute(100);
        assertEquals("1", values.getFizzBuzzValues().get(0).getValue());
        assertEquals("Fizz", values.getFizzBuzzValues().get(2).getValue());
        assertEquals("Buzz", values.getFizzBuzzValues().get(4).getValue());
        assertEquals("FizzBuzz", values.getFizzBuzzValues().get(14).getValue());
        assertEquals("Buzz", values.getFizzBuzzValues().get(99).getValue());
    }

    @Test
    public void 値が3で割り切れる場合はFizzをプリントする() {
        FizzBuzzValue value = (FizzBuzzValue) _fizzBuzzValueCommand.execute(3);
        assertEquals("Fizz", value.getValue());
        value = (FizzBuzzValue) _fizzBuzzValueCommand.execute(1);
        assertEquals("1", value.getValue());
    }

    @Test
    public void 値が5で割り切れる場合はBuzzをプリントする() {
        FizzBuzzValue value = (FizzBuzzValue) _fizzBuzzValueCommand.execute(5);
        assertEquals("Buzz", value.getValue());
    }

    @Test
    public void 値が3と5で割り切れる場合はFizzBuzzをプリントする() {
        FizzBuzzValue value = (FizzBuzzValue) _fizzBuzzValueCommand.execute(15);
        assertEquals("FizzBuzz", value.getValue());
    }

    @Test
    public void タイプ1は通常のパターンを返す() {
        FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("one"));
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("one"));
        FizzBuzzValue value = (FizzBuzzValue) fizzBuzzValueCommand.execute(3);
        assertEquals("Fizz", value.getValue());
        FizzBuzzValues values = (FizzBuzzValues) fizzBuzzValuesCommand.execute(100);
        assertEquals("Buzz", values.getFizzBuzzValues().get(4).getValue());
        assertEquals("FizzBuzz", values.getFizzBuzzValues().get(14).getValue());
    }

    @Test
    public void タイプ2は数字のみのパターンを返す() {
        FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("two"));
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("two"));
        FizzBuzzValue value = (FizzBuzzValue) fizzBuzzValueCommand.execute(3);
        assertEquals("3", value.getValue());
        FizzBuzzValues values = (FizzBuzzValues) fizzBuzzValuesCommand.execute(100);
        assertEquals("5", values.getFizzBuzzValues().get(4).getValue());
        assertEquals("15", values.getFizzBuzzValues().get(14).getValue());
    }

    @Test
    public void タイプ3はFizzBuzzのみのパターンを返す() {
        FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("three"));
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("three"));
        FizzBuzzValue value = (FizzBuzzValue) fizzBuzzValueCommand.execute(3);
        assertEquals("3", value.getValue());
        FizzBuzzValues values = (FizzBuzzValues) fizzBuzzValuesCommand.execute(100);
        assertEquals("5", values.getFizzBuzzValues().get(4).getValue());
        assertEquals("FizzBuzz", values.getFizzBuzzValues().get(14).getValue());
    }

    @Test
    public void リストは100件以上生成しない() {
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("one"));
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            fizzBuzzValuesCommand.execute(101);
        });
        assertEquals("FizzBuzzValues can't generate over 100", exception.getMessage());
    }
}
