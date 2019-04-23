package org.hiroshima_arc.application.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;

public interface IFizzBuzzCommand {
    IFizzBuzz execute(int number);
}
