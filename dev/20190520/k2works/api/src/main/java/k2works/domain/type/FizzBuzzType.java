package k2works.domain.type;

import k2works.domain.model.FizzBuzzValue;

public enum FizzBuzzType {

  one(new FizzBuzzType01()),
  two(new FizzBuzzType02()),
  three(new FizzBuzzType03());

  private IFizzBuzzType _type;

  FizzBuzzType(IFizzBuzzType type) {
    this._type = type;
  }

  public FizzBuzzValue generate(int number) {
    return new FizzBuzzValue(number, _type.generate(number));
  }

}

