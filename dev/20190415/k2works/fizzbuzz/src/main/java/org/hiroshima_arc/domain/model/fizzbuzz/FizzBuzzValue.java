package org.hiroshima_arc.domain.model.fizzbuzz;

import java.util.List;

public class FizzBuzzValue implements IFizzBuzz {
    private final Integer _number;
    private final String _value;

    public FizzBuzzValue(Integer number, String value) {
        if (number < 0) throw  new IllegalArgumentException("FizzBuzzValue can't generate minus number");
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
