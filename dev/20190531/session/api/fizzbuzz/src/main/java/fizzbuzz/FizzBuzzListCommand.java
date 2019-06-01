package fizzbuzz;

import fizzbuzz.domain.model.FizzBuzzList;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzListCommand implements IFizzBuzzCommand {
  private FizzBuzzType _type;
  private FizzBuzzList _list;

  public FizzBuzzListCommand(FizzBuzzType type) {
    _type = type;
  }

  @Override
  public IFizzBuzz execute(int maxNumber) {
    if (maxNumber < 0)
    throw new IllegalArgumentException(
      "FizzBuzzList can't generate by minus number"
    );
    List<FizzBuzzValue> list = new ArrayList<>();
    _list = new FizzBuzzList(list);

    IntStream.rangeClosed(1, maxNumber).forEach(
      number -> _list = _list.add(_type.generate(number))
    );

    return _list;
  }

}

