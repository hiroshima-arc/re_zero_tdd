using System.Collections.Generic;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static int[] GenerateList()
        {
            var list = new int[100];
            for (var i = 1; i <= 100; i++)
            {
                list[i - 1] = i;
            }

            return list;
        }

        public static string Generate(int number)
        {
            if (number % 3 == 0 && number % 5 == 0) return "FizzBuzz";
            if (number % 3 == 0) return "Fizz";
            return number % 5 == 0 ? "Buzz" : number.ToString();
        }
    }
}