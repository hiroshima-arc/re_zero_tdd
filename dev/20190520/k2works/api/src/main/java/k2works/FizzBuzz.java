package k2works;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  private FizzBuzzValues _values;
  private FizzBuzzType _type;

  public FizzBuzz(FizzBuzzType type) {
    List<FizzBuzzValue> list = new ArrayList<>();
    _values = new FizzBuzzValues(list);
    this._type = type;
  }

  public FizzBuzzValue generate(int number) {
    return this._type.generate(number);
  }

  public FizzBuzzValues generateList() {
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> _values = this._values.add(this.generate(number))
    );
    return _values;
  }

}

