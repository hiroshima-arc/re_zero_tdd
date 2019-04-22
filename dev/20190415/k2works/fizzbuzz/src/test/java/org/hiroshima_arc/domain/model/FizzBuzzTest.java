package org.hiroshima_arc.domain.model;

import org.hiroshima_arc.application.FizzBuzzValueCommand;
import org.hiroshima_arc.application.FizzBuzzValuesCommand;
import org.hiroshima_arc.application.IFizzBuzzCommand;
import org.hiroshima_arc.domain.type.FizzBuzzType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private IFizzBuzz _fizzBuzz;
    private IFizzBuzzCommand _fizzBuzzValueCommand;
    private IFizzBuzzCommand _fizzBuzzValuesCommand;

    @BeforeEach
    void init() {
        _fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("one"));
        _fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("one"));
    }

    @Test
    @DisplayName("値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする")
    public void testPrintValue() {
        _fizzBuzz = _fizzBuzzValuesCommand.execute(100);
        assertEquals("1", _fizzBuzz.getValues().get(0).getValue());
        assertEquals("Fizz", _fizzBuzz.getValues().get(2).getValue());
        assertEquals("Buzz", _fizzBuzz.getValues().get(4).getValue());
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14).getValue());
        assertEquals("Buzz", _fizzBuzz.getValues().get(99).getValue());
    }

    @Test
    @DisplayName("値が3で割り切れる場合はFizzをプリントする")
    public void testGenerateFizz() {
        _fizzBuzz = _fizzBuzzValueCommand.execute(3);
        assertEquals("Fizz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("値が5で割り切れる場合はBuzzをプリントする")
    public void testGenerateBuzz() {
        _fizzBuzz = _fizzBuzzValueCommand.execute(5);
        assertEquals("Buzz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("値が3と5で割り切れる場合はFizzBuzzをプリントする")
    public void testGenerateFizzBuzz() {
        _fizzBuzz = _fizzBuzzValueCommand.execute(15);
        assertEquals("FizzBuzz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Value() {
        IFizzBuzzCommand command = new FizzBuzzValueCommand(FizzBuzzType.valueOf("one"));
        _fizzBuzz = command.execute(3);
        assertEquals("Fizz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ1は通常のパターンを返す")
    public void testType1Values() {
        IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("one"));
        _fizzBuzz = command.execute(3);
        assertEquals("Fizz", _fizzBuzz.getValues().get(2).getValue());
    }

    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Value() {
        IFizzBuzzCommand command = new FizzBuzzValueCommand(FizzBuzzType.valueOf("two"));
        _fizzBuzz = command.execute(3);
        assertEquals("3", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ2は数字のみのパターンを返す")
    public void testType2Values() {
        IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("two"));
        _fizzBuzz = command.execute(3);
        assertEquals("3", _fizzBuzz.getValues().get(2).getValue());
    }

    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Value() {
        IFizzBuzzCommand command = new FizzBuzzValueCommand(FizzBuzzType.valueOf("three"));
        _fizzBuzz = command.execute(3);
        assertEquals("3", _fizzBuzz.getValue());
        _fizzBuzz = command.execute(15);
        assertEquals("FizzBuzz", _fizzBuzz.getValue());
    }

    @Test
    @DisplayName("タイプ3はFizzBuzzのみのパターンを返す")
    public void testType3Values() {
        IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.valueOf("three"));
        _fizzBuzz = command.execute(3);
        assertEquals("3", _fizzBuzz.getValues().get(2).getValue());
        _fizzBuzz = command.execute(15);
        assertEquals("FizzBuzz", _fizzBuzz.getValues().get(14).getValue());
    }
}
