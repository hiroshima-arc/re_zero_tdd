package fizzbuzz.application;


import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.model.FizzBuzzValues;
import fizzbuzz.domain.model.IFizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzValuesCommand implements IFizzBuzzCommand{
    private FizzBuzzType _type;
    private FizzBuzzValues _values;

    public FizzBuzzValuesCommand(FizzBuzzType type) {
        _type = type;
        List<FizzBuzzValue> list = new ArrayList<>();
        _values = new FizzBuzzValues(list);
    }

    @Override
    public IFizzBuzzValue execute(int arg) {
        if ( arg > 100) throw new IllegalArgumentException("FizzBuzzValues can't generate over 100");
        IntStream.rangeClosed(1,arg).forEach(i -> this._values = this._values.add(this._type.generate(i)));
        return this._values;
    }
}
