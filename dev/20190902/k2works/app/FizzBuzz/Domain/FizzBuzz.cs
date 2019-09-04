using System.Collections.Generic;
using System.Linq;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static List<string> GenerateList()
        {
            var list = new List<string>();
            foreach (var i in Enumerable.Range(1, 100))
            {
                var value = Generate(i);
                list.Add(value);
            }

            return list;
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