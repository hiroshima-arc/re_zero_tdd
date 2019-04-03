package fizzbuzz;

public class FizzBuzzType01 extends IFizzBuzzType {
    public FizzBuzzValue generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return new FizzBuzzValue(number,"FizzBuzz");
        if (fizz) return new FizzBuzzValue(number,"Fizz");
        if (buzz) return new FizzBuzzValue(number,"Buzz");
        return new FizzBuzzValue(number,Integer.toString(number));
    }
}

