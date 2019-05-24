package fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
  private static final int MAX_NUMBER = 100;

  private List<String> _list;

  public List<String> getList() {
    return _list;
  }

  public void generateList() {
    this.generateList(1);
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

  public void generateList(int type) {
    _list = IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> FizzBuzz.generate(number, type)
    ).collect(Collectors.toList());
  }

  public static String generate(int number, int type) {
    switch (type) {
      case 1:
        return FizzBuzz.generate(number);
      case 2:
        return Integer.toString(number);
      case 3:
        String result = Integer.toString(number);
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz) {
          return "FizzBuzz";
        }
        return result;
      default:
        return FizzBuzz.generate(number);
    }
  }

}

