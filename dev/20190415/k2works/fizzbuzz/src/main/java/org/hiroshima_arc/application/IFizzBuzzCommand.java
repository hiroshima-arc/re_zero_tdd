package org.hiroshima_arc.application;

import org.hiroshima_arc.domain.model.IFizzBuzz;

public interface IFizzBuzzCommand {
    IFizzBuzz execute(int number);
}
