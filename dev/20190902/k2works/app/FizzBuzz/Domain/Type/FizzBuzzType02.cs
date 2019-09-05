using FizzBuzz.Application.Command;
using FizzBuzz.Domain.Model;

namespace FizzBuzz.Domain.Type
{
    public class FizzBuzzType02: FizzBuzzType

    {
        public override IFizzBuzz Generate(int number)
    {
        return new FizzBuzzValue(number,number.ToString());
    }
    }
}