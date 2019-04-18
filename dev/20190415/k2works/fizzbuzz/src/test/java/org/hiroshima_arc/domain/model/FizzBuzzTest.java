package org.hiroshima_arc.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void 値を1から100までプリントする() {
        int[] list = FizzBuzz.printValue();
        assertEquals(1, list[0]);
        assertEquals(100, list[99]);
    }
}
