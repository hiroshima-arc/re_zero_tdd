namespace FizzBuzz.Application.Service
{
    public class FizzBuzzService
    {
        private IFizzBuzzCommand _command;

        public FizzBuzzService(IFizzBuzzCommand command)
        {
            _command = command;
        }

        public IFizzBuzz Generate(int number)
        {
            return _command.Execute(number);
        }

        public IFizzBuzz GenerateList(int number)
        {
            return _command.Execute(number);
        }

    }
}