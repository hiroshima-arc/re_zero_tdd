package helloworld;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    private String _value;
    private List<String> _values;

    public String getValue() {
        return _value;
    }

    public List<String> getValues() {
        return _values;
    }

    public void generateFizzBuzzList(int type) {
        this._values = IntStream.rangeClosed(1,100).mapToObj(i -> this.generate(i, type)).collect(Collectors.toList());
    }

    public void print() {
        this._values.forEach(System.out::println);
    }

    public String generate(int i) {
        boolean fizz = isFizz(i);
        boolean buzz = isBuzz(i);
        if (fizz && buzz) return this._value = "FizzBuzz";
        if (fizz) return this._value = "Fizz";
        if (buzz) return this._value = "Buzz";
        return this._value = Integer.toString(i);
    }

    public String generate(int i, int type) {
        switch (type) {
            case 1:
                return this.generate(i);
            case 2:
                return this._value = Integer.toString(i);
            case 3:
                boolean fizz = isFizz(i);
                boolean buzz = isBuzz(i);
                if (fizz && buzz) return this._value = "FizzBuzz";
                return this._value = Integer.toString(i);
            default:
                return this.generate(i);
        }
    }

    private boolean isBuzz(int i) {
        return i % 5 == 0;
    }

    private boolean isFizz(int i) {
        return i % 3 == 0;
    }
}
