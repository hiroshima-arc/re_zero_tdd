package org.hiroshima_arc.application.service.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;
import org.hiroshima_arc.domain.type.fizzbuzz.FizzBuzzType;

public class FizzBuzzValueService implements IFizzBuzzService {
    private FizzBuzzType _type;

    public FizzBuzzValueService(FizzBuzzType type) {
        _type = type;
    }

    @Override
    public IFizzBuzz execute(int number) {
        return  _type.generate(number);
    }
}
