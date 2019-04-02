package helloworld;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    private FizzBuzzValue _value;
    private List<FizzBuzzValue> _values;
    private FizzBuzzType _type;

    public FizzBuzz(FizzBuzzType type) {
        this._type = type;
    }

    public String getValue() {
        return _value.getValue();
    }

    public List<FizzBuzzValue> getValues() {
        return _values;
    }

    public void generateFizzBuzzList() {
        this._values = IntStream.rangeClosed(1,100).mapToObj(this::generate).collect(Collectors.toList());
    }

    public void print() {
        this._values.forEach(value -> System.out.println(value.getValue()));
    }

    public FizzBuzzValue generate(int i) {
        return this._value = this._type.generate(i);
    }
}
