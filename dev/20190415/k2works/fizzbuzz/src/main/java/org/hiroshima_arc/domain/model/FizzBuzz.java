package org.hiroshima_arc.domain.model;

import org.hiroshima_arc.domain.type.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    private FizzBuzzValue _value;
    private FizzBuzzValues _values;
    private FizzBuzzType _type;

    public FizzBuzz() {
        List<FizzBuzzValue> list = new ArrayList<>();
        _values = new FizzBuzzValues(list);
        _type = FizzBuzzType.valueOf("one");
    }

    public FizzBuzz(FizzBuzzType type) {
        List<FizzBuzzValue> list = new ArrayList<>();
        _values = new FizzBuzzValues(list);
        this._type = type;
    }

    public FizzBuzzValue getValue() {
        return _value;
    }

    public List<FizzBuzzValue> getValues() {
        return _values.get_values();
    }

    public void printValue() {
        _values.get_values().forEach(System.out::println);
    }

    public void generateList() {
        IntStream.rangeClosed(1, 100).forEach(i -> _values = _values.add(_type.generate(i)));
    }

    public String generate(int number) {
        _value = _type.generate(number);
        return _value.getValue();
    }
}
