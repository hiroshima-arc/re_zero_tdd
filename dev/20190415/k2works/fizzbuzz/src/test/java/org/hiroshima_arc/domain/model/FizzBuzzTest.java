package org.hiroshima_arc.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void 値を1から100までプリントする() {
        assertEquals(1, FizzBuzz.printValue());
    }
}
