package org.hiroshima_arc.domain.model;

import org.hiroshima_arc.domain.type.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    private String _value;
    private List<String> _values;
    private FizzBuzzType _type;

    public FizzBuzz() {
        _values = new ArrayList<>();
        _type = FizzBuzzType.valueOf("one");
    }

    public FizzBuzz(FizzBuzzType type) {
        _values = new ArrayList<>();
        this._type = type;
    }

    public String getValue() {
        return _value;
    }

    public List<String> getValues() {
        return _values;
    }

    public void printValue() {
        _values.forEach(System.out::println);
    }

    public void generateList() {
        IntStream.rangeClosed(1, 100).forEach(i -> _values.add(_type.generate(i)));
    }

    public String generate(int number) {
        _value = _type.generate(number);
        return _value;
    }
}
