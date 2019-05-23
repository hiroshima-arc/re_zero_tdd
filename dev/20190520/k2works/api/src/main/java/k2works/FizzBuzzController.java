package k2works;

import java.util.List;

import k2works.domain.FizzBuzzType;
import k2works.domain.FizzBuzzValue;
import k2works.domain.FizzBuzzValuesCommand;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz/{type}")
  public List<FizzBuzzValue> index(
    @PathVariable
    String type
  ) {
    IFizzBuzzCommand command = new FizzBuzzValuesCommand(
      FizzBuzzType.valueOf(type)
    );
    IFizzBuzz list = command.execute(100);
    return list.getValues();
  }

}

