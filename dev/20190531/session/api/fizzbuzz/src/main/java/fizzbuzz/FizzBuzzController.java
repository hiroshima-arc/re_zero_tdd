package fizzbuzz;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public List<FizzBuzzValue> fizzbuzz() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    List<FizzBuzzValue> list = fizzBuzz.generateList().getList();
    return list;
  }

}

