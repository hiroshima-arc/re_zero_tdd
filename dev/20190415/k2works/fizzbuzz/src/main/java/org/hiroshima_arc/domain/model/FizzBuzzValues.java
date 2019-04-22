package org.hiroshima_arc.domain.model;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValues implements IFizzBuzz {
    private final List<FizzBuzzValue> _values;

    public FizzBuzzValues(List<FizzBuzzValue> values) {
        this._values = values;
    }
    public List<FizzBuzzValue> get_values() {
        return _values;
    }

    public FizzBuzzValues add(FizzBuzzValue value) {
        List<FizzBuzzValue> result = new ArrayList<>(_values);
        result.add(value);
        return new FizzBuzzValues(result);
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public List<FizzBuzzValue> getValues() {
        return _values;
    }
}
