using System;
using System.Linq;
using FizzBuzz.Application.Service;
using FizzBuzz.Domain.Model;

namespace FizzBuzz.Application.Command
{
    public class FizzBuzzListCommand: IFizzBuzzCommand
    {
        private IFizzBuzzType _type;

        public FizzBuzzListCommand(IFizzBuzzType type)
        {
            _type = type;
        }

        public IFizzBuzz Execute(int number)
        {
            if (number < 0) throw new ArgumentException("FizzBuzzList can't generate by minus number'");
            return new FizzBuzzList(Enumerable.Range(1, number).Select(i => _type.Generate(i)).ToList());
        }
    }
}