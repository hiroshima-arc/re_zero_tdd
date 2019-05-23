package k2works;

public class FizzBuzzValue implements IFizzBuzz {
  private final Integer _number;
  private final String _value;

  FizzBuzzValue(Integer number, String value) {
    this._number = number;
    this._value = value;
  }

  public Integer getNumber() {
    return _number;
  }

  public String getValue() {
    return _value;
  }

}

