package org.hiroshima_arc.domain.model.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzNullValue implements IFizzBuzz {
    @Override
    public String getValue() {
        return "";
    }

    @Override
    public List<FizzBuzzValue> getValues() {
        FizzBuzzValue value = new FizzBuzzValue(0, "");
        List<FizzBuzzValue> list = new ArrayList<>();
        list.add(value);
        return list;
    }
}
