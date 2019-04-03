package fizzbuzz;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzValuesCommand implements IFizzBuzzCommand{
    private FizzBuzzType _type;
    private FizzBuzzValues _values;

    FizzBuzzValuesCommand(FizzBuzzType type) {
        _type = type;
        List<FizzBuzzValue> list = new ArrayList<>();
        _values = new FizzBuzzValues(list);
    }

    public List<FizzBuzzValue> getValues() {
        return _values.getFizzBuzzValues();
    }

    @Override
    public void execute(int arg) {
        IntStream.rangeClosed(1,arg).forEach(i -> this._values = this._values.add(this._type.generate(i)));
    }
}
