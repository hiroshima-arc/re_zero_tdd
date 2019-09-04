using System.Collections.Generic;
using System.Linq;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static List<string> GenerateList()
        {
            return Enumerable.Range(1, 100).Select(i => Generate(i)).ToList();
        }

        public static string Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz) return "FizzBuzz";
            if (isFizz) return "Fizz";
            return isBuzz ? "Buzz" : number.ToString();
        }
    }
}