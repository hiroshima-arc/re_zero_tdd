package k2works;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  public static final String FIZZ_BUZZ = "FizzBuzz";
  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";
  private List<String> _valuse;
  private FizzBuzzType01 _type01;

  public List<String> getValuse() {
    return _valuse;
  }

  public FizzBuzz() {
    this._valuse = new ArrayList<>();
    this._type01 = new FizzBuzzType01();
  }

  public static String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz)
    return FIZZ_BUZZ;
    if (isFizz)
    return FIZZ;
    if (isBuzz)
    return BUZZ;
    return Integer.toString(number);
  }

  public String generate(int number, int type) {
    switch (type) {
      case 1:
        return this._type01.generate(number);
      case 2:
        return Integer.toString(number);
      case 3:
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz)
        return FIZZ_BUZZ;
        return Integer.toString(number);
      default:
        return FizzBuzz.generate(number);
    }
  }

  public void generateList() {
    this.generateList(1);
  }

  public void generateList(int type) {
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> this._valuse.add(this.generate(number, type))
    );
  }

}

