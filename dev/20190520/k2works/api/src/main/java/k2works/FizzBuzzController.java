package k2works;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public List<String> index() {
    FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    fizzBuzz.generateList();
    return fizzBuzz.getValuse();
  }

}

