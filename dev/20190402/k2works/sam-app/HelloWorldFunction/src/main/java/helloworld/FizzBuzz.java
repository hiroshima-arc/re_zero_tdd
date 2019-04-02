package helloworld;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    private String _value;
    private List<String> _values;
    private FizzBuzzType _type;

    public FizzBuzz(FizzBuzzType type) {
        this._type = type;
    }

    public String getValue() {
        return _value;
    }

    public List<String> getValues() {
        return _values;
    }

    public void generateFizzBuzzList() {
        this._values = IntStream.rangeClosed(1,100).mapToObj(this::generate).collect(Collectors.toList());
    }

    public void print() {
        this._values.forEach(System.out::println);
    }

    public String generate(int i) {
        return this._value = this._type.generate(i);
    }
}
