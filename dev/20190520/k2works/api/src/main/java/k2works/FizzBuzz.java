package k2works;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

  public static String generate(int number) {
    String result = Integer.toString(number);
    if (number % 3 == 0 && number % 5 == 0) {
      result = "FizzBuzz";
    } else if (number % 3 == 0) {
      result = "Fizz";
    } else if (number % 5 == 0) {
      result = "Buzz";
    }
    return result;
  }

  public static List<String> generateList() {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= 100; i++) {
      list.add(FizzBuzz.generate(i));
    }
    return list;
  }

}

