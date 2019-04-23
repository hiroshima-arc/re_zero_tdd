package org.hiroshima_arc.domain.model;

import java.util.List;

public class FizzBuzzValue implements IFizzBuzz {
    private final Integer _number;
    private final String _value;

    public FizzBuzzValue(Integer number, String value) {
        assert (number >= 0) : "FizzBuzzValue can't generate minus number";
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
        IFizzBuzz values = new FizzBuzzNullValue();
        return values.getValues();
    }
}
