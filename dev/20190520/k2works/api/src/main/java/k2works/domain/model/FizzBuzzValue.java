package k2works.domain.model;

import java.util.ArrayList;
import java.util.List;

import k2works.application.service.IFizzBuzz;

public class FizzBuzzValue implements IFizzBuzz {
  private final Integer _number;
  private final String _value;

  public FizzBuzzValue(Integer number, String value) {
    if (number < 0)
    throw new IllegalArgumentException(
      "FizzBuzzValue can't generate by minus number"
    );
    this._number = number;
    this._value = value;
  }

  public Integer getNumber() {
    return _number;
  }

  public String getValue() {
    return _value;
  }

  @Override
  public List<FizzBuzzValue> getValues() {
    return new ArrayList<>();
  }

}

