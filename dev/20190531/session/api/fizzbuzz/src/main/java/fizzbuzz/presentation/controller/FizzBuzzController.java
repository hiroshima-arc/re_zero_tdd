package fizzbuzz.presentation.controller;

import fizzbuzz.application.service.FizzBuzzService;
import fizzbuzz.domain.model.FizzBuzzValue;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz/{type}")
  public List<FizzBuzzValue> fizzbuzz(
    @PathVariable
    String type
  ) {
    FizzBuzzService service = new FizzBuzzService();
    return service.generateList(type);
  }

}

