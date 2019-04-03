package fizzbuzz.application;

import fizzbuzz.domain.model.IFizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

public class FizzBuzzValueCommand implements IFizzBuzzCommand{
    private FizzBuzzType _type;

    public FizzBuzzValueCommand(FizzBuzzType type) {
        _type = type;
    }

    @Override
    public IFizzBuzzValue execute(int arg) {
        return _type.generate(arg);
    }
}
