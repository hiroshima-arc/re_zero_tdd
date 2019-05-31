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
  private FizzBuzzType _type;

  public FizzBuzz(int type) {
    switch (type) {
      case 1:
        _type = new FizzBuzzType01();
        break;
      case 2:
        _type = new FizzBuzzType02();
        break;
      case 3:
        _type = new FizzBuzzType03();
        break;
      default:
        _type = new FizzBuzzType01();
    }
  }

  public List<String> getList() {
    return _list;
  }

  public void generateList() {
    _list = IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> this.generate(number)
    ).collect(Collectors.toList());
  }

  public String generate(int number) {
    return _type.generate(number);
  }

}

