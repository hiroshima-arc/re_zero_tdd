using System.Collections.Generic;
using System.Diagnostics;

namespace FizzBuzz.Domain
{
    public class FizzBuzzList: IFizzBuzz
    {
        private readonly List<IFizzBuzz> _list;

        public FizzBuzzList(List<IFizzBuzz> list)
        {
            Debug.Assert(list.Count <= 100);
            _list = list;
        }

        public List<IFizzBuzz> List => _list;

        public FizzBuzzList Add(FizzBuzzValue value)
        {
            var result = new List<IFizzBuzz>(_list);
            result.Add(value);
            return new FizzBuzzList(result);
        }

        public string GetValue()
        {
            return "";
        }

        public List<IFizzBuzz> GetList()
        {
            return List;
        }
    }
}