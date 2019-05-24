package fizzbuzz;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public String[] fizzbuzz() {
    String[] list = FizzBuzz.print1To100();
    return list;
  }

}

