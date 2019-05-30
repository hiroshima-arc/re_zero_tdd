package fizzbuzz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @RequestMapping("/fizzbuzz")
  public String[] fizzbuzz() {
    String[] list = new String[5];
    list[0] = "1";
    list[1] = "2";
    list[2] = "Fizz";
    list[3] = "4";
    list[4] = "Buzz";

    return list;
  }

}

