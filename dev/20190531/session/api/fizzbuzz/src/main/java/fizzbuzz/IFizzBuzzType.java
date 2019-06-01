package fizzbuzz;

abstract class IFizzBuzzType {
  public static final String FIZZ_BUZZ = "FizzBuzz";
  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";

  abstract FizzBuzzValue generate(int number);

}

