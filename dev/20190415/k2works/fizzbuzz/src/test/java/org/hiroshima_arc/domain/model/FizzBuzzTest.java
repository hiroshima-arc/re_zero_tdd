package org.hiroshima_arc.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzzData _fizzBuzzData;
    @BeforeEach
    void init() {
       _fizzBuzzData = new FizzBuzzData();
    }

    @Test
    @DisplayName("値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする")
    public void testPrintValue() {
        _fizzBuzzData.setValues(FizzBuzz.generateList());
        assertEquals("1", _fizzBuzzData.getValues().get(0));
        assertEquals("Fizz", _fizzBuzzData.getValues().get(2));
        assertEquals("Buzz", _fizzBuzzData.getValues().get(4));
        assertEquals("FizzBuzz", _fizzBuzzData.getValues().get(14));
        assertEquals("Buzz", _fizzBuzzData.getValues().get(99));
    }
    @Test
    @DisplayName("値が3で割り切れる場合はFizzをプリントする")
    public void testGenerateFizz() {
        _fizzBuzzData.setValue(FizzBuzz.generate(3));
        assertEquals("Fizz", _fizzBuzzData.getValue());
    }
    @Test
    @DisplayName("値が5で割り切れる場合はBuzzをプリントする")
    public void testGenerateBuzz() {
        _fizzBuzzData.setValue(FizzBuzz.generate(5));
        assertEquals("Buzz", _fizzBuzzData.getValue());
    }
    @Test
    @DisplayName("値が3と5で割り切れる場合はFizzBuzzをプリントする")
    public void testGenerateFizzBuzz() {
        _fizzBuzzData.setValue(FizzBuzz.generate(15));
        assertEquals("FizzBuzz", _fizzBuzzData.getValue());
    }
    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Value() {
        _fizzBuzzData.setValue(FizzBuzz.generate(3, 1));
        assertEquals("Fizz", _fizzBuzzData.getValue());
    }
    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Values() {
        _fizzBuzzData.setValues(FizzBuzz.generateList(1));
       assertEquals("Fizz", _fizzBuzzData.getValues().get(2));
    }
    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Value() {
        _fizzBuzzData.setValue(FizzBuzz.generate(3, 2));
        assertEquals("3", _fizzBuzzData.getValue());
    }
    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Values() {
        _fizzBuzzData.setValues(FizzBuzz.generateList(2));
        assertEquals("3", _fizzBuzzData.getValues().get(2));
    }
    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Value() {
        assertEquals("3", FizzBuzz.generate(3, 3));
        assertEquals("FizzBuzz", FizzBuzz.generate(15, 3));
    }
}
