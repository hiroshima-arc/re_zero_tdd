package k2works.presentation.controller;

import java.util.List;

import k2works.application.service.FizzBuzzService;
import k2works.domain.model.FizzBuzzValue;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz/{type}")
  public List<FizzBuzzValue> generateList(
    @PathVariable
    String type
  ) {
    FizzBuzzService service = new FizzBuzzService();
    return service.generateList(type);
  }

}

