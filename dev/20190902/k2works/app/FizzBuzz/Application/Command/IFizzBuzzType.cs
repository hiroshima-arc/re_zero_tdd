using FizzBuzz.Application.Service;

namespace FizzBuzz.Application.Command
{
    public interface IFizzBuzzType
    {
    IFizzBuzz Generate(int number);
    }
}