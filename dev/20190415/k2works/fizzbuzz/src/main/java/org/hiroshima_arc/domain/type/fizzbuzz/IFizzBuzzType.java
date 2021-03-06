package org.hiroshima_arc.domain.type.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;

abstract class IFizzBuzzType {
    FizzBuzzValue generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return  new FizzBuzzValue(number,"FizzBuzz");
        if (fizz) return new FizzBuzzValue(number, "Fizz");
        if (buzz) return new FizzBuzzValue(number,"Buzz");
        return new FizzBuzzValue(number,Integer.toString(number));
    }

    protected boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    protected boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
