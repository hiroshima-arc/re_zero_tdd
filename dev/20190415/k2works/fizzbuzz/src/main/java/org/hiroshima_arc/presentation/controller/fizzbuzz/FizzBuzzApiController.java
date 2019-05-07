package org.hiroshima_arc.presentation.controller.fizzbuzz;

import org.hiroshima_arc.application.service.fizzbuzz.FizzBuzzApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FizzBuzzApiController {
    @CrossOrigin
    @RequestMapping(value = "/api/fizzbuzz/{type}", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public List fizzBuzzValues(@PathVariable String type) {
        FizzBuzzApiService service = new FizzBuzzApiService(type);
        return service.execute(100);
    }
}

