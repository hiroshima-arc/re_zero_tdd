using System.Collections.Generic;

namespace FizzBuzz.Domain
{
    public interface IFizzBuzz
    {
        string GetValue();

        List<IFizzBuzz> GetList();
    }
}