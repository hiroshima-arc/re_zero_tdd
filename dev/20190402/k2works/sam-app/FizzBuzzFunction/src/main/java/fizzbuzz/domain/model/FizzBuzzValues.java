package fizzbuzz.domain.model;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValues implements IFizzBuzzValue {
    private List<FizzBuzzValue> _fizzBuzzValues;

    public List<FizzBuzzValue> getFizzBuzzValues() {
        return _fizzBuzzValues;
    }

    public FizzBuzzValues(List<FizzBuzzValue> fizzBuzzValues) {
        _fizzBuzzValues = fizzBuzzValues;
    }

    public FizzBuzzValues add(FizzBuzzValue fizzBuzzValue) {
        List<FizzBuzzValue> result = new ArrayList<>(_fizzBuzzValues);
        result.add(fizzBuzzValue);
        return new FizzBuzzValues(result);
    }
}
