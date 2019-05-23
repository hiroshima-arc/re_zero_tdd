package k2works;

import k2works.domain.type.FizzBuzzType;

public class FizzBuzzValueCommand implements IFizzBuzzCommand {
  private FizzBuzzType _type;

  public FizzBuzzValueCommand(FizzBuzzType type) {
    _type = type;
  }

  @Override
  public IFizzBuzz execute(int number) {
    return _type.generate(number);
  }

}

