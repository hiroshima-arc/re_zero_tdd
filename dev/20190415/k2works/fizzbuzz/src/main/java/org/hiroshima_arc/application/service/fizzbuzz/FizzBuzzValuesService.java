package org.hiroshima_arc.application.service.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;
import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValues;
import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;
import org.hiroshima_arc.domain.type.fizzbuzz.FizzBuzzType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzValuesService implements IFizzBuzzService {
    private FizzBuzzType _type;
    private FizzBuzzValues _values;

    public FizzBuzzValuesService(FizzBuzzType type) {
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
