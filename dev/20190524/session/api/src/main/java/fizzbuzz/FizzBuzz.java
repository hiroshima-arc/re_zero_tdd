package fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  private static final int MAX_NUMBER = 100;

  private List<String> _list;
  private FizzBuzzType01 _type01;
  private FizzBuzzType02 _type02;

  public List<String> getList() {
    return _list;
  }

  public FizzBuzz() {
    _list = new ArrayList<>();
    _type01 = new FizzBuzzType01();
    _type02 = new FizzBuzzType02();
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
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> _list.add(this.generate(number, type))
    );
  }

  public String generate(int number, int type) {
    switch (type) {
      case 1:
        return _type01.generate(number);
      case 2:
        return _type02.generate(number);
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

