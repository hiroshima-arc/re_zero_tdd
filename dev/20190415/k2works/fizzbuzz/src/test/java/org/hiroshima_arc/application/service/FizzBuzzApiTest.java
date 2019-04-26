package org.hiroshima_arc.application.service;

import org.hiroshima_arc.application.service.fizzbuzz.FizzBuzzApiService;
import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzApiTest {
    @Test
    @DisplayName("1から100までのオブジェクトリストを返す")
    void testFizzBuzzValues() {
        FizzBuzzApiService service = new FizzBuzzApiService();
        List<FizzBuzzEntity> result = service.execute(100);
        assertEquals("1",Integer.toString(result.get(0).getNumber()));
        assertEquals("1",result.get(0).getValue());
        assertEquals("100",Integer.toString(result.get(99).getNumber()));
        assertEquals("Buzz",result.get(99).getValue());
    }
}
