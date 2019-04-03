package fizzbuzz.domain.type;

import fizzbuzz.domain.model.FizzBuzzValue;

public abstract class IFizzBuzzType {
    public abstract FizzBuzzValue generate(int number);

    protected boolean isBuzz(int i) {
        return i % 5 == 0;
    }

    protected boolean isFizz(int i) {
        return i % 3 == 0;
    }
}
