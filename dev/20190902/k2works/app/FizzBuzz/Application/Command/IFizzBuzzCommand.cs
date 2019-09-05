namespace FizzBuzz.Application.Command
{
    public interface IFizzBuzzCommand
    {
        IFizzBuzz Execute(int number);
    }
}