namespace FizzBuzz.Domain
{
    public class FizzBuzzType02: FizzBuzzType

    {
        public override IFizzBuzz Generate(int number)
    {
        return new FizzBuzzValue(number,number.ToString());
    }
    }
}