using FizzBuzz.Application.Service;

namespace FizzBuzz.Application.Command
{
    public class FizzBuzzValueCommand: IFizzBuzzCommand
    {
        private IFizzBuzzType _type;

        public FizzBuzzValueCommand(IFizzBuzzType type)
        {
            _type = type;
        }
        public IFizzBuzz Execute(int number)
        {
            return _type.Generate(number);
        }
    }
}