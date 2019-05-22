package k2works;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValues {
  private final List<FizzBuzzValue> _values;

  public FizzBuzzValues(List<FizzBuzzValue> values) {
    _values = values;
  }

  public List<FizzBuzzValue> get_values() {
    return _values;
  }

  public FizzBuzzValues add(FizzBuzzValue value) {
    List<FizzBuzzValue> result = new ArrayList<>(_values);
    result.add(value);
    return new FizzBuzzValues(result);
  }

}

