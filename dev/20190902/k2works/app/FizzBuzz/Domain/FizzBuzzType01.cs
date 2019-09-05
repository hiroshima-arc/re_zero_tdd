namespace FizzBuzz.Domain
{
    public class FizzBuzzType01: FizzBuzzType 
    {
        public override string Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;

            if (isFizz && isBuzz)
            {
                return FIZZ_BUZZ;
            }

            if (isFizz)
            {
                return FIZZ;
            }

            if (isBuzz)
            {
                return BUZZ;
            }

            return number.ToString();
        }
    }
}
