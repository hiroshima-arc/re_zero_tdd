using System.Collections.Generic;

namespace FizzBuzz.Application.Service
{
    public interface IFizzBuzz
    {
        string GetValue();

        List<IFizzBuzz> GetList();
    }
}