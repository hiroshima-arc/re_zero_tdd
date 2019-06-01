package fizzbuzz.domain.type;

import fizzbuzz.domain.model.FizzBuzzValue;

public class FizzBuzzType03
  extends IFizzBuzzType {

  public FizzBuzzValue generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;
    if (isFizz && isBuzz) {
      return new FizzBuzzValue(number, IFizzBuzzType.FIZZ_BUZZ);
    }
    return new FizzBuzzValue(number, Integer.toString(number));
  }

}

