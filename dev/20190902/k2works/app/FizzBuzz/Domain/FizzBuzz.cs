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
        private FizzBuzzType _type;
        public FizzBuzz(int type)
        {
            switch (type)
            {
                case 1:
                    _type = new FizzBuzzType01();
                    break;
                case 2:
                    _type = new FizzBuzzType02();
                    break;
                case 3:
                    _type = new FizzBuzzType03();
                    break;
                default:
                    _type = new FizzBuzzType01();
                    break;
            }
        }

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
                    return _type.Generate(number);
                case 2:
                    return _type.Generate(number);
                case 3:
                    return _type.Generate(number);
                default:
                    return _type.Generate(number);
            }
        }
    }
}