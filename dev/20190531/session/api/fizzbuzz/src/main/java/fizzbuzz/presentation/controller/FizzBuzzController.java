package fizzbuzz.presentation.controller;

import fizzbuzz.FizzBuzzListCommand;
import fizzbuzz.IFizzBuzzCommand;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz/{type}")
  public List<FizzBuzzValue> fizzbuzz(
    @PathVariable
    String type
  ) {
    IFizzBuzzCommand command = new FizzBuzzListCommand(
      FizzBuzzType.valueOf(type)
    );
    return command.execute(100).getList();
  }

}
