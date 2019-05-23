package k2works;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public List<FizzBuzzValue> index() {
    IFizzBuzzCommand command = new FizzBuzzValuesCommand(FizzBuzzType.one);
    IFizzBuzz list = command.execute(100);
    return list.getValues();
  }

}

