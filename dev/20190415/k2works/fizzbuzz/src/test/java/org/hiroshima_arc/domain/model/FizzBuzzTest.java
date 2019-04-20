package org.hiroshima_arc.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzz _fizzBuzz;

    @BeforeEach
    void init() {
        _fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする")
    public void testPrintValue() {
        _fizzBuzz.generateList();
        assertEquals("1", _fizzBuzz.getValues().get(0));
        assertEquals("Fizz", _fizzBuzz.getValues().get(2));
        assertEquals("Buzz", _fizzBuzz.getValues().get(4));
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14));
        assertEquals("Buzz", _fizzBuzz.getValues().get(99));
    }

    @Test
    @DisplayName("値が3で割り切れる場合はFizzをプリントする")
    public void testGenerateFizz() {
        _fizzBuzz.setValue(_fizzBuzz.generate(3));
        assertEquals("Fizz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("値が5で割り切れる場合はBuzzをプリントする")
    public void testGenerateBuzz() {
        _fizzBuzz.setValue(_fizzBuzz.generate(5));
        assertEquals("Buzz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("値が3と5で割り切れる場合はFizzBuzzをプリントする")
    public void testGenerateFizzBuzz() {
        _fizzBuzz.setValue(_fizzBuzz.generate(15));
        assertEquals("FizzBuzz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Value() {
        _fizzBuzz.setValue(_fizzBuzz.generate(3, 1));
        assertEquals("Fizz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Values() {
        _fizzBuzz.generateList(1);
        assertEquals("Fizz", _fizzBuzz.getValues().get(2));
    }

    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Value() {
        _fizzBuzz.setValue(_fizzBuzz.generate(3, 2));
        assertEquals("3", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Values() {
        _fizzBuzz.generateList(2);
        assertEquals("3", _fizzBuzz.getValues().get(2));
    }

    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Value() {
        assertEquals("3", _fizzBuzz.generate(3, 3));
        assertEquals("FizzBuzz", _fizzBuzz.generate(15, 3));
    }

    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Values() {
        _fizzBuzz.generateList(3);
        assertEquals("3", _fizzBuzz.getValues().get(2));
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14));
    }
}
