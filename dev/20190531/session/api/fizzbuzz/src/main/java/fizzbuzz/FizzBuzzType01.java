package fizzbuzz;

public class FizzBuzzType01 {
  private int number;

  public FizzBuzzType01(int number) {
    this.number = number;
  }

  public String generate() {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz) {
      return FizzBuzz.FIZZ_BUZZ;
    }
    if (isFizz) {
      return FizzBuzz.FIZZ;
    }
    if (isBuzz) {
      return FizzBuzz.BUZZ;
    }
    return Integer.toString(number);
  }

}

