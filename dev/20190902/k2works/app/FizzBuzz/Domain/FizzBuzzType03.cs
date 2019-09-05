namespace FizzBuzz.Domain
{
    public class FizzBuzzType03
    {
        public string Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz)
            {
                return FizzBuzz.FIZZ_BUZZ;
            }

            return number.ToString();
        }
    }
}