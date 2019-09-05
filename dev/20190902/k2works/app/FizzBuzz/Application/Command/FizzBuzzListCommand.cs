using System;
using System.Linq;
using FizzBuzz.Domain.Model;
using FizzBuzz.Domain.Type;

namespace FizzBuzz.Application.Command
{
    public class FizzBuzzListCommand: IFizzBuzzCommand
    {
        private FizzBuzzType _type;

        public FizzBuzzListCommand(FizzBuzzType type)
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