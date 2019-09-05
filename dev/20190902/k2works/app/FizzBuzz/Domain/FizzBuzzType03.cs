namespace FizzBuzz.Domain
{
    public class FizzBuzzType03
    {
        private readonly int _number;

        public FizzBuzzType03(int number)
        {
            _number = number;
        }

        public string Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz)
            {
                return FizzBuzz.FIZZ_BUZZ;
            }

            return _number.ToString();
        }
    }
}