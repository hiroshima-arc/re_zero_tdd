package fizzbuzz;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public List<String> fizzbuzz() {
    FizzBuzz fizzBuzz = new FizzBuzz(1);
    fizzBuzz.generateList();
    List<String> list = fizzBuzz.getList();
    return list;
  }

}

