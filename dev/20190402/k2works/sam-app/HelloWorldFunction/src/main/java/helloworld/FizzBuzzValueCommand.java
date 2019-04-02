package helloworld;

public class FizzBuzzValueCommand implements IFizzBuzzCommand{
    private FizzBuzzType _type;
    private FizzBuzzValue _value;

    FizzBuzzValueCommand(FizzBuzzType type) {
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
