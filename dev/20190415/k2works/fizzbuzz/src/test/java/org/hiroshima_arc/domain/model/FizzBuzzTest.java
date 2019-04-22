package org.hiroshima_arc.domain.model;

import org.hiroshima_arc.domain.type.FizzBuzzType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzz _fizzBuzz;
    private FizzBuzz _fizzBuzzType01;
    private FizzBuzz _fizzBuzzType02;
    private FizzBuzz _fizzBuzzType03;

    @BeforeEach
    void init() {
        _fizzBuzz = new FizzBuzz();
        _fizzBuzzType01 = new FizzBuzz(FizzBuzzType.valueOf("one"));
        _fizzBuzzType02 = new FizzBuzz(FizzBuzzType.valueOf("two"));
        _fizzBuzzType03 = new FizzBuzz(FizzBuzzType.valueOf("three"));
    }

    @Test
    @DisplayName("値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする")
    public void testPrintValue() {
        _fizzBuzz.generateList();
        assertEquals("1", _fizzBuzz.getValues().get(0).getValue());
        assertEquals("Fizz", _fizzBuzz.getValues().get(2).getValue());
        assertEquals("Buzz", _fizzBuzz.getValues().get(4).getValue());
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14).getValue());
        assertEquals("Buzz", _fizzBuzz.getValues().get(99).getValue());
    }

    @Test
    @DisplayName("値が3で割り切れる場合はFizzをプリントする")
    public void testGenerateFizz() {
        assertEquals("Fizz", _fizzBuzz.generate(3));
    }

    @Test
    @DisplayName("値が5で割り切れる場合はBuzzをプリントする")
    public void testGenerateBuzz() {
        assertEquals("Buzz", _fizzBuzz.generate(5));
    }

    @Test
    @DisplayName("値が3と5で割り切れる場合はFizzBuzzをプリントする")
    public void testGenerateFizzBuzz() {
        assertEquals("FizzBuzz", _fizzBuzz.generate(15));
    }

    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Value() {
        assertEquals("Fizz", _fizzBuzzType01.generate(3));
    }

    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Values() {
        _fizzBuzzType01.generateList();
        assertEquals("Fizz", _fizzBuzzType01.getValues().get(2).getValue());
    }

    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Value() {
        assertEquals("3", _fizzBuzzType02.generate(3));
    }

    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Values() {
        _fizzBuzzType02.generateList();
        assertEquals("3", _fizzBuzzType02.getValues().get(2).getValue());
    }

    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Value() {
        assertEquals("3", _fizzBuzzType03.generate(3));
        assertEquals("FizzBuzz", _fizzBuzzType03.generate(15));
    }

    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Values() {
        _fizzBuzzType03.generateList();
        assertEquals("3", _fizzBuzzType03.getValues().get(2).getValue());
        assertEquals("FizzBuzz", _fizzBuzzType03.getValues().get(14).getValue());
    }
}
