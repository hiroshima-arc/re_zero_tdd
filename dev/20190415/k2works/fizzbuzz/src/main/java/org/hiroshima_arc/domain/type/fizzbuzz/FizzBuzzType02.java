package org.hiroshima_arc.domain.type.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;

class FizzBuzzType02 extends IFizzBuzzType {
    @Override
    FizzBuzzValue generate(int number) {
        return new FizzBuzzValue(number,String.valueOf(number));
    }
}
