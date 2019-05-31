package fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  public static final String FIZZ_BUZZ = "FizzBuzz";
  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";

  private List<String> _list;

  public List<String> getList() {
    return _list;
  }

  public void setList(List<String> list) {
    _list = list;
  }

  public static List<String> generateList() {
    return IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      FizzBuzz::generate
    ).collect(Collectors.toList());
  }

  public static List<String> generateList(int type) {
    return IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> FizzBuzz.generate(number, type)
    ).collect(Collectors.toList());
  }

  public static String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz) {
      return FIZZ_BUZZ;
    }
    if (isFizz) {
      return FIZZ;
    }
    if (isBuzz) {
      return BUZZ;
    }
    return Integer.toString(number);
  }

  public static String generate(int number, int type) {
    switch (type) {
      case 1:
        return FizzBuzz.generate(number);
      case 2:
        return Integer.toString(number);
      case 3:
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz) {
          return FIZZ_BUZZ;
        }
        return Integer.toString(number);
      default:
        return FizzBuzz.generate(number);
    }
  }

}

