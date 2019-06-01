package fizzbuzz;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public List<FizzBuzzValue> fizzbuzz() {
    IFizzBuzzCommand command = new FizzBuzzListCommand(FizzBuzzType.one);
    return command.execute(100).getList();
  }

}

