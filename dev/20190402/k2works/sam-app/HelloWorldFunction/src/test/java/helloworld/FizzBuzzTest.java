
package helloworld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzz _fizzBuzz;

    @BeforeEach
    void init() {
        _fizzBuzz = new FizzBuzz(FizzBuzzType.valueOf("one"));
    }

    @Test
    public void 値を1から100までをプリントする() {
        _fizzBuzz.generateFizzBuzzList();
        assertEquals("1", _fizzBuzz.getValues().get(0).getValue());
        assertEquals("Fizz", _fizzBuzz.getValues().get(2).getValue());
        assertEquals("Buzz", _fizzBuzz.getValues().get(4).getValue());
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14).getValue());
        assertEquals("Buzz", _fizzBuzz.getValues().get(99).getValue());
        _fizzBuzz.print();
    }

    @Test
    public void 値が3で割り切れる場合はFizzをプリントする() {
        _fizzBuzz.generate(3);
        assertEquals("Fizz", _fizzBuzz.getValue());
        _fizzBuzz.generate(1);
        assertEquals("1", _fizzBuzz.getValue());
    }

    @Test
    public void 値が5で割り切れる場合はBuzzをプリントする() {
        _fizzBuzz.generate(5);
        assertEquals("Buzz", _fizzBuzz.getValue());
    }

    @Test
    public void 値が3と5で割り切れる場合はFizzBuzzをプリントする() {
        _fizzBuzz.generate(15);
        assertEquals("FizzBuzz", _fizzBuzz.getValue());
    }

    @Test
    public void タイプ1は通常のパターンを返す() {
        FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.valueOf("one"));
        assertEquals("Fizz", fizzBuzz.generate(3).getValue());
        fizzBuzz.generateFizzBuzzList();
        assertEquals("Buzz", fizzBuzz.getValues().get(4).getValue());
        assertEquals("FizzBuzz", fizzBuzz.getValues().get(14).getValue());
    }

    @Test
    public void タイプ2は数字のみのパターンを返す() {
        FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.valueOf("two"));
        assertEquals("3", fizzBuzz.generate(3).getValue());
        fizzBuzz.generateFizzBuzzList();
        assertEquals("5", fizzBuzz.getValues().get(4).getValue());
        assertEquals("15", fizzBuzz.getValues().get(14).getValue());
    }

    @Test
    public void タイプ3はFizzBuzzのみのパターンを返す() {
        FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.valueOf("three"));
        assertEquals("3", fizzBuzz.generate(3).getValue());
        fizzBuzz.generateFizzBuzzList();
        assertEquals("5", fizzBuzz.getValues().get(4).getValue());
        assertEquals("FizzBuzz", fizzBuzz.getValues().get(14).getValue());
    }
}
