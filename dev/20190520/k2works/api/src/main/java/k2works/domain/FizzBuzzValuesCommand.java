package k2works.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import k2works.IFizzBuzz;
import k2works.IFizzBuzzCommand;
import k2works.domain.FizzBuzzType;
import k2works.domain.FizzBuzzValue;
import k2works.domain.FizzBuzzValues;

public class FizzBuzzValuesCommand implements IFizzBuzzCommand {
  private FizzBuzzType _type;
  private FizzBuzzValues _values;

  public FizzBuzzValuesCommand(FizzBuzzType type) {
    _type = type;
  }

  @Override
  public IFizzBuzz execute(int maxNumber) {
    List<FizzBuzzValue> list = new ArrayList<>();
    _values = new FizzBuzzValues(list);

    IntStream.rangeClosed(1, maxNumber).forEach(
      number -> _values = this._values.add(this._type.generate(number))
    );

    return _values;
  }

}

