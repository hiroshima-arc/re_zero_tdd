package org.hiroshima_arc.presentation.controller.fizzbuzz;

import org.hiroshima_arc.application.service.fizzbuzz.FizzBuzzApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzApiController {
    @RequestMapping(value = "/api/fizzbuzz", method = RequestMethod.GET)
    public List fizzBuzzValues() {
        FizzBuzzApiService service = new FizzBuzzApiService();
        return service.execute(100);
    }
}

