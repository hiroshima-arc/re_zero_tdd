package k2works;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  @CrossOrigin
  @RequestMapping("/fizzbuzz")
  public List index() {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("Fizz");
    list.add("4");
    list.add("Buzz");
    return list;
  }

}

