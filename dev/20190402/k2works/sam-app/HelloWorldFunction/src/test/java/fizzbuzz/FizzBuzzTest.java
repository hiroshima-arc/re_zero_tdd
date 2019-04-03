
package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        _fizzBuzzValuesCommand.execute(100);
        assertEquals("1", _fizzBuzzValuesCommand.getValues().get(0).getValue());
        assertEquals("Fizz", _fizzBuzzValuesCommand.getValues().get(2).getValue());
        assertEquals("Buzz", _fizzBuzzValuesCommand.getValues().get(4).getValue());
        assertEquals("FizzBuzz", _fizzBuzzValuesCommand.getValues().get(14).getValue());
        assertEquals("Buzz", _fizzBuzzValuesCommand.getValues().get(99).getValue());
    }

    @Test
    public void 値が3で割り切れる場合はFizzをプリントする() {
        _fizzBuzzValueCommand.execute(3);
        assertEquals("Fizz", _fizzBuzzValueCommand.getValue());
        _fizzBuzzValueCommand.execute(1);
        assertEquals("1", _fizzBuzzValueCommand.getValue());
    }

    @Test
    public void 値が5で割り切れる場合はBuzzをプリントする() {
        _fizzBuzzValueCommand.execute(5);
        assertEquals("Buzz", _fizzBuzzValueCommand.getValue());
    }

    @Test
    public void 値が3と5で割り切れる場合はFizzBuzzをプリントする() {
        _fizzBuzzValueCommand.execute(15);
        assertEquals("FizzBuzz", _fizzBuzzValueCommand.getValue());
    }

    @Test
    public void タイプ1は通常のパターンを返す() {
        FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("one"));
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("one"));
        fizzBuzzValueCommand.execute(3);
        assertEquals("Fizz", fizzBuzzValueCommand.getValue());
        fizzBuzzValuesCommand.execute(100);
        assertEquals("Buzz", fizzBuzzValuesCommand.getValues().get(4).getValue());
        assertEquals("FizzBuzz", fizzBuzzValuesCommand.getValues().get(14).getValue());
    }

    @Test
    public void タイプ2は数字のみのパターンを返す() {
        FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("two"));
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("two"));
        fizzBuzzValueCommand.execute(3);
        assertEquals("3", fizzBuzzValueCommand.getValue());
        fizzBuzzValuesCommand.execute(100);
        assertEquals("5", fizzBuzzValuesCommand.getValues().get(4).getValue());
        assertEquals("15", fizzBuzzValuesCommand.getValues().get(14).getValue());
    }

    @Test
    public void タイプ3はFizzBuzzのみのパターンを返す() {
        FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("three"));
        FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("three"));
        fizzBuzzValueCommand.execute(3);
        assertEquals("3", fizzBuzzValueCommand.getValue());
        fizzBuzzValuesCommand.execute(100);
        assertEquals("5", fizzBuzzValuesCommand.getValues().get(4).getValue());
        assertEquals("FizzBuzz", fizzBuzzValuesCommand.getValues().get(14).getValue());
    }
}
