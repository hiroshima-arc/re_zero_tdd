package org.hiroshima_arc.domain.type;

import org.hiroshima_arc.domain.model.FizzBuzzValue;

public class FizzBuzzType02 extends IFizzBuzzType {
    @Override
    public FizzBuzzValue generate(int number) {
        return new FizzBuzzValue(number,String.valueOf(number));
    }
}
