package fizzbuzz.application;

import fizzbuzz.domain.model.IFizzBuzzValue;

public interface IFizzBuzzCommand {
    IFizzBuzzValue execute(int arg);
}
