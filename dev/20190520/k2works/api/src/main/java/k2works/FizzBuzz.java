package k2works;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  private List<String> _valuse;
  private FizzBuzzType _type;

  public List<String> getValuse() {
    return _valuse;
  }

  public FizzBuzz(FizzBuzzType type) {
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

