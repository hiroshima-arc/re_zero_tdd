namespace FizzBuzz.Domain
{
    public interface IFizzBuzzCommand
    {
        IFizzBuzz Execute(int number);
    }
}