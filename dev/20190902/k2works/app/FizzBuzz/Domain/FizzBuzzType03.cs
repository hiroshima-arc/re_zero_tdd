namespace FizzBuzz.Domain
{
    public class FizzBuzzType03
    {
        private readonly int _number;

        public FizzBuzzType03(int number)
        {
            _number = number;
        }

        public string Generate()
        {
            var isFizz = _number % 3 == 0;
            var isBuzz = _number % 5 == 0;
            if (isFizz && isBuzz)
            {
                return FizzBuzz.FIZZ_BUZZ;
            }

            return _number.ToString();
        }
    }
}