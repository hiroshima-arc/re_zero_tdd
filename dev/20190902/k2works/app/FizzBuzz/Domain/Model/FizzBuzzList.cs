using System;
using System.Collections.Generic;
using FizzBuzz.Application.Service;

namespace FizzBuzz.Domain.Model
{
    public class FizzBuzzList: IFizzBuzz
    {
        private readonly List<IFizzBuzz> _list;
        private static readonly int MAX_NUMBER = 100;

        public FizzBuzzList(List<IFizzBuzz> list)
        {
            if (list.Count > MAX_NUMBER) throw new ArgumentException("FizzBuzzList can't generate over 100''");
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