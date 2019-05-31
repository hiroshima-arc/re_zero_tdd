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
        return new FizzBuzzType02(number).generate();
      case 3:
        return new FizzBuzzType03(number).generate();
      default:
        return new FizzBuzzType01(number).generate();
    }
  }

}

