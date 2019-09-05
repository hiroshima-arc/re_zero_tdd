namespace FizzBuzz.Domain
{
    public class FizzBuzzType02: FizzBuzzType

    {
        public override FizzBuzzValue Generate(int number)
    {
        return new FizzBuzzValue(number,number.ToString());
    }
    }
}