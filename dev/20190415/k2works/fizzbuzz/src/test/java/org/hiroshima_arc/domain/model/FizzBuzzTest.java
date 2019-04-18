package org.hiroshima_arc.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    @DisplayName("値を1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする")
    public void testPrintValue() {
        List<String> list = FizzBuzz.generateList();
        assertEquals("1", list.get(0));
        assertEquals("Fizz", list.get(2));
        assertEquals("Buzz", list.get(4));
        assertEquals("FizzBuzz", list.get(14));
        assertEquals("Buzz", list.get(99));
    }
    @Test
    @DisplayName("値が3で割り切れる場合はFizzをプリントする")
    public void testGenerateFizz() {
        assertEquals("Fizz", FizzBuzz.generate(3));
    }
    @Test
    @DisplayName("値が5で割り切れる場合はBuzzをプリントする")
    public void testGenerateBuzz() {
        assertEquals("Buzz", FizzBuzz.generate(5));
    }
    @Test
    @DisplayName("値が3と5で割り切れる場合はFizzBuzzをプリントする")
    public void testGenerateFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.generate(15));
    }
}
