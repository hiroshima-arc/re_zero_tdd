package org.hiroshima_arc.application.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;
import org.hiroshima_arc.domain.type.fizzbuzz.FizzBuzzType;

public class FizzBuzzValueCommand implements IFizzBuzzCommand {
    private FizzBuzzType _type;

    public FizzBuzzValueCommand(FizzBuzzType type) {
        _type = type;
    }

    @Override
    public IFizzBuzz execute(int number) {
        return  _type.generate(number);
    }
}
