package org.hiroshima_arc.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    private String _value;
    private List<String> _values;

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public FizzBuzz() {
        this._values = new ArrayList<>();
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
        generateList(1);
    }

    public void generateList(int type) {
        IntStream.rangeClosed(1, 100).forEach(i -> _values.add(generate(i, type)));
    }

    public String generate(int number) {
        _value = Integer.toString(number);
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz) _value = FIZZ;
        if (buzz) _value = BUZZ;
        if (fizz && buzz) _value = FIZZ_BUZZ;
        return _value;
    }

    public String generate(int number, int type) {
        switch (type) {
            case 1:
                return generate(number);
            case 2:
                return String.valueOf(number);
            case 3:
                _value = Integer.toString(number);
                boolean fizz = isFizz(number);
                boolean buzz = isBuzz(number);
                if (fizz && buzz) _value = FIZZ_BUZZ;
                return _value;
            default:
                return generate(number);
        }
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
