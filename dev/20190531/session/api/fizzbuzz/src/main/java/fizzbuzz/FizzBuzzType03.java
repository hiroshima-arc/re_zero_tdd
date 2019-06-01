package fizzbuzz;

public class FizzBuzzType03
  extends FizzBuzzType {

  public String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;
    if (isFizz && isBuzz) {
      return FizzBuzzType.FIZZ_BUZZ;
    }
    return Integer.toString(number);
  }

}

