package org.hiroshima_arc.domain.model;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValues implements IFizzBuzz {
    private final List<FizzBuzzValue> _values;

    public FizzBuzzValues(List<FizzBuzzValue> values) {
        if (values.size() > 100) throw new IllegalArgumentException("FizzBuzzValues can't generate over 100");
        this._values = values;
    }

    public FizzBuzzValues add(FizzBuzzValue value) {
        List<FizzBuzzValue> result = new ArrayList<>(_values);
        result.add(value);
        return new FizzBuzzValues(result);
    }

    @Override
    public String getValue() {
        IFizzBuzz value = new FizzBuzzNullValue();
        return value.getValue();
    }

    @Override
    public List<FizzBuzzValue> getValues() {
        return _values;
    }
}
