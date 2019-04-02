package helloworld;

public enum FizzBuzzType {
    one(new FizzBuzzType01()),
    two(new FizzBuzzType02()),
    three(new FizzBuzzType03());

    private IFizzBuzzType type;

    FizzBuzzType(IFizzBuzzType type) {
       this.type = type;
    }

    FizzBuzzValue generate(int number) {
        return type.generate(number);
    }
}
