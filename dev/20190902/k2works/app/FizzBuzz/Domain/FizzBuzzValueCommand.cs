namespace FizzBuzz.Domain
{
    public class FizzBuzzValueCommand: IFizzBuzzCommand
    {
        private FizzBuzzType _type;

        public FizzBuzzValueCommand(FizzBuzzType type)
        {
            _type = type;
        }
        public IFizzBuzz Execute(int number)
        {
            return _type.Generate(number);
        }
    }
}