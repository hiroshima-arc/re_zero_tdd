package fizzbuzz;

public class FizzBuzzType01
  extends IFizzBuzzType {

  public String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz) {
      return IFizzBuzzType.FIZZ_BUZZ;
    }
    if (isFizz) {
      return IFizzBuzzType.FIZZ;
    }
    if (isBuzz) {
      return IFizzBuzzType.BUZZ;
    }
    return Integer.toString(number);
  }

}

