package fizzbuzz;

public class FizzBuzzType03 {
  private int number;

  public FizzBuzzType03(int number) {
    this.number = number;
  }

  public String generate() {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;
    if (isFizz && isBuzz) {
      return FizzBuzz.FIZZ_BUZZ;
    }
    return Integer.toString(number);
  }

}

