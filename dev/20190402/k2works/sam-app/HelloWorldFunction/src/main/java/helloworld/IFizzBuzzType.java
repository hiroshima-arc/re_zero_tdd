package helloworld;

public abstract class IFizzBuzzType {
    abstract FizzBuzzValue generate(int number);

    protected boolean isBuzz(int i) {
        return i % 5 == 0;
    }

    protected boolean isFizz(int i) {
        return i % 3 == 0;
    }
}
