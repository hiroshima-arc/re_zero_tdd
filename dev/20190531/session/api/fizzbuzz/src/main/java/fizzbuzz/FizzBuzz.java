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
  private FizzBuzzType01 _type01;
  private FizzBuzzType02 _type02;
  private FizzBuzzType03 _type03;

  public FizzBuzz(int type) {
    switch (type) {
      case 1:
        _type01 = new FizzBuzzType01();
      case 2:
        _type02 = new FizzBuzzType02();
      case 3:
        _type03 = new FizzBuzzType03();
      default:
        _type01 = new FizzBuzzType01();
    }
  }

  public List<String> getList() {
    return _list;
  }

  public void generateList() {
    this.generateList(1);
  }

  public void generateList(int type) {
    _list = IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> this.generate(number, type)
    ).collect(Collectors.toList());
  }

  public String generate(int number, int type) {
    switch (type) {
      case 1:
        return _type01.generate(number);
      case 2:
        return _type02.generate(number);
      case 3:
        return _type03.generate(number);
      default:
        return _type01.generate(number);
    }
  }

}

