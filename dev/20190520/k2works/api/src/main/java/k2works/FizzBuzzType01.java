package k2works;

public class FizzBuzzType01 implements IFizzBuzzType {
  public static final String FIZZ_BUZZ = "FizzBuzz";
  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";

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

