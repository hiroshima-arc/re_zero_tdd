namespace FizzBuzz.Domain
{
    public class FizzBuzzType03: FizzBuzzType
    {
        public override IFizzBuzz Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz)
            {
                return new FizzBuzzValue(number,FIZZ_BUZZ);
            }

            return new FizzBuzzValue(number,number.ToString());
        }
    }
}