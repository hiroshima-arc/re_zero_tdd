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
  private IFizzBuzzType _type;

  public List<String> getValuse() {
    return _valuse;
  }

  public FizzBuzz(int type) {
    this._valuse = new ArrayList<>();

    switch (type) {
      case 1:
        this._type = new FizzBuzzType01();
        break;
      case 2:
        this._type = new FizzBuzzType02();
        break;
      case 3:
        this._type = new FizzBuzzType03();
        break;
      default:
        this._type = new FizzBuzzType01();
    }
  }

  public FizzBuzz(IFizzBuzzType type) {
    this._valuse = new ArrayList<>();
    this._type = type;
  }

  public String generate(int number) {
    return this._type.generate(number);
  }

  public void generateList() {
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> this._valuse.add(this.generate(number))
    );
  }

}

