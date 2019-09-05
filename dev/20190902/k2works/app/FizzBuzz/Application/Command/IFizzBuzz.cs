using System.Collections.Generic;

namespace FizzBuzz.Application.Command
{
    public interface IFizzBuzz
    {
        string GetValue();

        List<IFizzBuzz> GetList();
    }
}