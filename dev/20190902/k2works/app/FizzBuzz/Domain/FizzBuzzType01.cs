using System;

namespace FizzBuzz.Domain
{
    public class FizzBuzzType01
    {
        private readonly int _number;

        public FizzBuzzType01(int number)
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

            if (isFizz)
            {
                return FizzBuzz.FIZZ;
            }

            if (isBuzz)
            {
                return FizzBuzz.BUZZ;
            }

            return _number.ToString();
        }
    }
}