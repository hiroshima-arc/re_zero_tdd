using System.Collections.Generic;
using System.Linq;

namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static readonly int MAX_NUMBER = 100;
        public List<FizzBuzzValue> List
        {
            get => _list.List;
        }

        private FizzBuzzList _list;
        private FizzBuzzType _type;
        public FizzBuzz(FizzBuzzType type)
        {
            _type = type;
        }

        public void GenerateList()
        {
            _list = new FizzBuzzList(Enumerable.Range(1, MAX_NUMBER).Select(i => _type.Generate(i)).ToList());
        }
        public FizzBuzzValue Generate(int number)
        {
            return _type.Generate(number);
        }
    }
}