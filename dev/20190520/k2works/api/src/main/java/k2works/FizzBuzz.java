package k2works;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  private List<FizzBuzzValue> _values;
  private FizzBuzzType _type;

  public List<FizzBuzzValue> getValues() {
    return _values;
  }

  public FizzBuzz(FizzBuzzType type) {
    this._values = new ArrayList<>();
    this._type = type;
  }

  public FizzBuzzValue generate(int number) {
    return this._type.generate(number);
  }

  public void generateList() {
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> this._values.add(this.generate(number))
    );
  }

}

