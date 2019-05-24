package k2works.domain.type;

public class FizzBuzzType03
  extends IFizzBuzzType {

  public String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz)
    return FIZZ_BUZZ;
    return Integer.toString(number);
  }

}

