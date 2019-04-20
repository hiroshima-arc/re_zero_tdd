package org.hiroshima_arc.domain.type;

public abstract class IFizzBuzzType {
    public String generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return "FizzBuzz";
        if (fizz) return "Fizz";
        if (buzz) return "Buzz";
        return Integer.toString(number);
    }

    protected boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    protected boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
