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

  public void generateList() {
    this.generateList(1);
  }

  public void generateList(int type) {
    _list = IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> FizzBuzz.generate(number, type)
    ).collect(Collectors.toList());
  }

  public static String generate(int number, int type) {
    switch (type) {
      case 1:
        return new FizzBuzzType01(number).generate();
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
        return new FizzBuzzType01(number).generate();
    }
  }

}

