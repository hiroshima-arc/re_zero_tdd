package k2works.domain.type;

public class FizzBuzzType01
  extends IFizzBuzzType {

  public String generate(int number) {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz)
    return FIZZ_BUZZ;
    if (isFizz)
    return FIZZ;
    if (isBuzz)
    return BUZZ;
    return Integer.toString(number);
  }

}

