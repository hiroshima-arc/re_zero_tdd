package org.hiroshima_arc.domain.type.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;

class FizzBuzzType03 extends IFizzBuzzType {
    @Override
    FizzBuzzValue generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return new FizzBuzzValue(number,"FizzBuzz");
        return new FizzBuzzValue(number,Integer.toString(number));
    }
}
