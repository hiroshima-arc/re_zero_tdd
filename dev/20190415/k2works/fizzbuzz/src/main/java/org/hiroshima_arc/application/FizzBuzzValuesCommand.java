package org.hiroshima_arc.application;

import org.hiroshima_arc.domain.model.FizzBuzzValue;
import org.hiroshima_arc.domain.model.FizzBuzzValues;
import org.hiroshima_arc.domain.model.IFizzBuzz;
import org.hiroshima_arc.domain.type.FizzBuzzType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzValuesCommand implements IFizzBuzzCommand {
    private FizzBuzzType _type;
    private FizzBuzzValues _values;

    public FizzBuzzValuesCommand(FizzBuzzType type) {
        _type = type;
    }

    @Override
    public IFizzBuzz execute(int number) {
        List<FizzBuzzValue> list = new ArrayList<>();
        _values = new FizzBuzzValues(list);
        IntStream.rangeClosed(1, number).forEach(i -> _values = _values.add(_type.generate(i)));
        return _values;
    }
}
