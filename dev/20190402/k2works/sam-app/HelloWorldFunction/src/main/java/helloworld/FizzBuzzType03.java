package helloworld;

public class FizzBuzzType03 extends IFizzBuzzType {
    @Override
    public FizzBuzzValue generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return new FizzBuzzValue(number,"FizzBuzz");
        return  new FizzBuzzValue(number,Integer.toString(number));
    }
}
