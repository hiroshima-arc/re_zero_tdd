package fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

  public static List<String> generateList() {
    return IntStream.rangeClosed(1, 100).mapToObj(FizzBuzz::generate).collect(
      Collectors.toList()
    );
  }

  public static String generate(int number) {
    String result = Integer.toString(number);

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
    return result;
  }

}

