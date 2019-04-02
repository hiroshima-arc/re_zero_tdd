package helloworld;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    private FizzBuzzValue _value;
    private FizzBuzzValues _values;
    private FizzBuzzType _type;

    public FizzBuzz(FizzBuzzType type) {
        this._type = type;
        List<FizzBuzzValue> list = new ArrayList<>();
        _values = new FizzBuzzValues(list);
    }

    public String getValue() {
        return _value.getValue();
    }

    public List<FizzBuzzValue> getValues() {
        return _values.getFizzBuzzValues();
    }

    public void generateFizzBuzzList() {
        IntStream.rangeClosed(1,100).forEach(i -> this._values = this._values.add(this.generate(i)));
    }

    public void print() {
        this._values.getFizzBuzzValues().forEach(value -> System.out.println(value.getValue()));
    }

    public FizzBuzzValue generate(int i) {
        return this._value = this._type.generate(i);
    }
}
