package org.hiroshima_arc.domain.type;

public class FizzBuzzType03 extends IFizzBuzzType {
    @Override
    public String generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return "FizzBuzz";
        return Integer.toString(number);
    }
}
