package k2works.domain.model;

import java.util.ArrayList;
import java.util.List;

import k2works.application.service.IFizzBuzz;

public class FizzBuzzValues implements IFizzBuzz {
  private final List<FizzBuzzValue> _values;

  public FizzBuzzValues(List<FizzBuzzValue> values) {
    if (values.size() > 100)
    throw new IllegalArgumentException(
      "FizzBuzzValues can't generate over 100"
    );
    _values = values;
  }

  @Override
  public String getValue() {
    return "";
  }

  public List<FizzBuzzValue> getValues() {
    return _values;
  }

  public FizzBuzzValues add(FizzBuzzValue value) {
    List<FizzBuzzValue> result = new ArrayList<>(_values);
    result.add(value);
    return new FizzBuzzValues(result);
  }

}

