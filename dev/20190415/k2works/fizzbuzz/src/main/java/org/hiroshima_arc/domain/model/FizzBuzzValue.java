package org.hiroshima_arc.domain.model;

public class FizzBuzzValue {
    private final Integer _number;
    private final String _value;

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
