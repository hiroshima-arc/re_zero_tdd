using System.Collections.Generic;

namespace FizzBuzz.Domain
{
    public class FizzBuzzList
    {
        private readonly List<FizzBuzzValue> _list;

        public FizzBuzzList(List<FizzBuzzValue> list)
        {
            _list = list;
        }

        public List<FizzBuzzValue> List => _list;

        public FizzBuzzList Add(FizzBuzzValue value)
        {
            var result = new List<FizzBuzzValue>(_list);
            result.Add(value);
            return new FizzBuzzList(result);
        }
    }
}