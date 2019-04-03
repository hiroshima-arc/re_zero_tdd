package fizzbuzz.application;

import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

public class FizzBuzzValueCommand implements IFizzBuzzCommand{
    private FizzBuzzType _type;
    private FizzBuzzValue _value;

    public FizzBuzzValueCommand(FizzBuzzType type) {
        _type = type;
    }

    public Integer getNumber() {
        return _value.getNumber();
    }

    public String getValue() {
        return _value.getValue();
    }

    @Override
    public void execute(int arg) {
        _value = _type.generate(arg);
    }
}
