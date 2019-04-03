package fizzbuzz.domain.model;

public class FizzBuzzValue implements IFizzBuzzValue {
    private Integer _number;
    private String _value;

    public FizzBuzzValue(Integer number, String value) {
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
