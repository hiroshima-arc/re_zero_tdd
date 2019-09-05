namespace FizzBuzz.Domain
{
    public abstract class FizzBuzzType
    {
        public static readonly string FIZZ = "Fizz";
        public static readonly string BUZZ = "Buzz";
        public static readonly string FIZZ_BUZZ = "FizzBuzz";
        public abstract string Generate(int number);
    }
}