package fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

  public static List<String> generateList() {
    List<String> list = new ArrayList<>();
    IntStream.rangeClosed(1, 100).forEach(
      number -> {
        list.add(FizzBuzz.generate(number));
      }
    );
    return list;
  }

  public static String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz) {
      return "FizzBuzz";
    }
    if (isFizz) {
      return "Fizz";
    }
    if (isBuzz) {
      return "Buzz";
    }
    return Integer.toString(number);
  }

}

