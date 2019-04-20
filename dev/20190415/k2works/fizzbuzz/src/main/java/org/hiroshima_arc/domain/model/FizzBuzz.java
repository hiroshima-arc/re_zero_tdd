package org.hiroshima_arc.domain.model;

import org.hiroshima_arc.domain.type.FizzBuzzType01;
import org.hiroshima_arc.domain.type.FizzBuzzType02;
import org.hiroshima_arc.domain.type.FizzBuzzType03;
import org.hiroshima_arc.domain.type.IFizzBuzzType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    private String _value;
    private List<String> _values;
    private IFizzBuzzType _type;

    public FizzBuzz() {
        _values = new ArrayList<>();
        _type = new FizzBuzzType01();
    }

    public FizzBuzz(int type) {
        _values = new ArrayList<>();
        switch (type) {
            case 1:
                _type = new FizzBuzzType01();
                break;
            case 2:
                _type = new FizzBuzzType02();
                break;
            case 3:
                _type = new FizzBuzzType03();
                break;
            default:
                _type = new FizzBuzzType01();
        }
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String _value) {
        this._value = _value;
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
