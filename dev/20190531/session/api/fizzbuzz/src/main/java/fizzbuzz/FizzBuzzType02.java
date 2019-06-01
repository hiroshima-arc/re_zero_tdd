package fizzbuzz;

public class FizzBuzzType02
  extends IFizzBuzzType {

  public FizzBuzzValue generate(int number) {
    return new FizzBuzzValue(number, Integer.toString(number));
  }

}

