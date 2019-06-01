package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValue implements IFizzBuzz {
  private final int _number;
  private final String _value;

  FizzBuzzValue(int number, String value) {
    _number = number;
    _value = value;
  }

  public int getNumber() {
    return _number;
  }

  public String getValue() {
    return _value;
  }

  @Override
  public List<FizzBuzzValue> getList() {
    return new ArrayList<>();
  }

}

