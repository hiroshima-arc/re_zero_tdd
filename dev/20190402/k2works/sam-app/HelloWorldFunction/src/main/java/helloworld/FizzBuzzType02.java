package helloworld;

public class FizzBuzzType02 extends IFizzBuzzType {
    @Override
    public FizzBuzzValue generate(int number) {
        return new FizzBuzzValue(number,Integer.toString(number));
    }
}