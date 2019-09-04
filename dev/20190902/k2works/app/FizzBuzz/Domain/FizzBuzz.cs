using System.Collections.Generic;
using System.Linq;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static readonly int MAX_NUMBER = 100;
        public static readonly string FIZZ = "Fizz";
        public static readonly string BUZZ = "Buzz";
        public static readonly string FIZZ_BUZZ = "FizzBuzz";
        

        public static List<string> GenerateList()
        {
            return Enumerable.Range(1, MAX_NUMBER).Select(i => Generate(i)).ToList();
        }

        public static string Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz) return FIZZ_BUZZ;
            if (isFizz) return FIZZ;
            return isBuzz ? BUZZ : number.ToString();
        }

        public static string Generate(int number, int type)
        {
            switch (type)
            {
                case 1:
                    return Generate(number);
                default:
                    return Generate(number);
            }
        }
    }
}