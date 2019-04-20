package org.hiroshima_arc.domain.type;

public enum FizzBuzzType {
    one(new FizzBuzzType01()),
    two(new FizzBuzzType02()),
    three(new FizzBuzzType03());

    private IFizzBuzzType _type;

    FizzBuzzType(IFizzBuzzType type) {
       this._type = type;
    }

    public String generate(int number) {
        return _type.generate(number);
    }
}
