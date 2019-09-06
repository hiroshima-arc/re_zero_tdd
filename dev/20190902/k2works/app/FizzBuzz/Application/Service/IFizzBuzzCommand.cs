namespace FizzBuzz.Application.Service
{
    public interface IFizzBuzzCommand
    {
        IFizzBuzz Execute(int number);
    }
}