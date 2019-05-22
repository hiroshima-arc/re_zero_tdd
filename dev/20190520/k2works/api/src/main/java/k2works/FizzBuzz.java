package k2works;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

  public static String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz)
    return "FizzBuzz";
    if (isFizz)
    return "Fizz";
    if (isBuzz)
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

