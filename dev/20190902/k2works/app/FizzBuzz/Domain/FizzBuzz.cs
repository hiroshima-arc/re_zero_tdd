using System.Collections.Generic;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static int[] Print1From100()
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
            var result = number.ToString();
            if (number % 3 == 0 && number % 5 == 0)
            {
                result = "FizzBuzz";
            } else if (number % 3 == 0)
            {
                result = "Fizz";
            } else if (number % 5 == 0)
            {
                result = "Buzz";
            }
            return result;
        }
    }
}