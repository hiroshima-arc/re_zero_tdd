package fizzbuzz.domain.type;

import fizzbuzz.domain.model.FizzBuzzValue;

public enum FizzBuzzType {
    one(new FizzBuzzType01()),
    two(new FizzBuzzType02()),
    three(new FizzBuzzType03());

    private IFizzBuzzType type;

    FizzBuzzType(IFizzBuzzType type) {
       this.type = type;
    }

    public FizzBuzzValue generate(int number) {
        return type.generate(number);
    }
}
