package k2works;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValue implements IFizzBuzz {
  private final Integer _number;
  private final String _value;

  FizzBuzzValue(Integer number, String value) {
    assert number >= 0 : "FizzBuzzValue can't generate by minus number";
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

