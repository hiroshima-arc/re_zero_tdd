
package helloworld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzz _fizzBuzz;

    @BeforeEach
    void init() {
        _fizzBuzz = new FizzBuzz();
    }

    @Test
    public void 値を1から100までをプリントする() {
        _fizzBuzz.generateFizzBuzzList(1);
        assertEquals("1", _fizzBuzz.getValues().get(0));
        assertEquals("Fizz", _fizzBuzz.getValues().get(2));
        assertEquals("Buzz", _fizzBuzz.getValues().get(4));
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14));
        assertEquals("Buzz", _fizzBuzz.getValues().get(99));
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
        assertEquals("Fizz", _fizzBuzz.generate(3, 1));
        _fizzBuzz.generateFizzBuzzList(1);
        assertEquals("Buzz", _fizzBuzz.getValues().get(4));
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14));
    }

    @Test
    public void タイプ2は数字のみのパターンを返す() {
        assertEquals("3", _fizzBuzz.generate(3, 2));
        _fizzBuzz.generateFizzBuzzList(2);
        assertEquals("5", _fizzBuzz.getValues().get(4));
        assertEquals("15", _fizzBuzz.getValues().get(14));
    }

    @Test
    public void タイプ3はFizzBuzzのみのパターンを返す() {
        assertEquals("3", _fizzBuzz.generate(3, 3));
        _fizzBuzz.generateFizzBuzzList(3);
        assertEquals("5", _fizzBuzz.getValues().get(4));
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14));
    }
}
