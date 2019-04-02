package helloworld;

public class FizzBuzzValue {
    private Integer _number;
    private String _value;

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
