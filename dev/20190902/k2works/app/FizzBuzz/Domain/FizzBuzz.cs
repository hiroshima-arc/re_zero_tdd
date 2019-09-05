using System.Collections.Generic;
using System.Linq;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static readonly int MAX_NUMBER = 100;
        public List<string> List
        {
            get => _list;
        }

        private List<string> _list;
        private FizzBuzzType _type;
        public FizzBuzz(FizzBuzzType type)
        {
            _type = type;
        }

        public void GenerateList()
        {
            _list = Enumerable.Range(1, MAX_NUMBER).Select(i => _type.Generate(i)).ToList();
        }
        public string Generate(int number)
        {
            return _type.Generate(number);
        }
    }
}