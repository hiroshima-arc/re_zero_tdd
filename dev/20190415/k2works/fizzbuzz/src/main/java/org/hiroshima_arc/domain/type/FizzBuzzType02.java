package org.hiroshima_arc.domain.type;

public class FizzBuzzType02 implements IFizzBuzzType{
    @Override
    public String generate(int number) {
        return String.valueOf(number);
    }
}
