using System;
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
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz) return "FizzBuzz";
            if (isFizz) return "Fizz";
            return isBuzz ? "Buzz" : number.ToString();
        }
    }
}