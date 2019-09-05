using System.Linq;

namespace FizzBuzz.Domain
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
           return new FizzBuzzList(Enumerable.Range(1, number).Select(i => _type.Generate(i)).ToList());
        }
    }
}