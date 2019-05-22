package k2works;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

  public static String generate(int number) {
    if (number % 3 == 0 && number % 5 == 0)
    return "FizzBuzz";
    if (number % 3 == 0)
    return "Fizz";
    if (number % 5 == 0)
    return "Buzz";
    return Integer.toString(number);
  }

  public static List<String> generateList() {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= 100; i++) {
      list.add(FizzBuzz.generate(i));
    }
    return list;
  }

}

