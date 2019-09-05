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
        public List<string> List
        {
            get => _list;
        }

        private List<string> _list;

        public void GenerateList()
        {
            GenerateList(1);
        }

        public void GenerateList(int type)
        {
            _list = Enumerable.Range(1, MAX_NUMBER).Select(i => Generate(i, type)).ToList();
        }
        
        public string Generate(int number)
        {
            var isFizz = number % 3 == 0;
            var isBuzz = number % 5 == 0;
            if (isFizz && isBuzz) return FIZZ_BUZZ;
            if (isFizz) return FIZZ;
            return isBuzz ? BUZZ : number.ToString();
        }

        public string Generate(int number, int type)
        {
            switch (type)
            {
                case 1:
                    return new FizzBuzzType01(number).Generate();
                case 2:
                    return new FizzBuzzType02(number).Generate();
                case 3:
                    if (number % 3 == 0 && number % 5 == 0)
                    {
                        return FIZZ_BUZZ;
                    }

                    return number.ToString();
                default:
                    return Generate(number);
            }
        }
    }
}