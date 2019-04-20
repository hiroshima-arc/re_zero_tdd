package org.hiroshima_arc.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private String _value;
    private List<String> _values;

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

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
        _values = IntStream.rangeClosed(1, 100).mapToObj(FizzBuzz::generate).collect(Collectors.toList());
    }

    public void generateList(int type) {
        _values = IntStream.rangeClosed(1, 100).mapToObj(i -> FizzBuzz.generate(i, type)).collect(Collectors.toList());
    }

    public static String generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return FIZZ_BUZZ;
        if (fizz) return FIZZ;
        if (buzz) return BUZZ;
        return Integer.toString(number);
    }

    public static String generate(int number, int type) {
        switch (type) {
            case 1:
                return FizzBuzz.generate(number);
            case 2:
                return String.valueOf(number);
            case 3:
                boolean fizz = isFizz(number);
                boolean buzz = isBuzz(number);
                if (fizz && buzz) return FIZZ_BUZZ;
                return Integer.toString(number);
            default:
                return FizzBuzz.generate(number);
        }
    }

    private static boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private static boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
