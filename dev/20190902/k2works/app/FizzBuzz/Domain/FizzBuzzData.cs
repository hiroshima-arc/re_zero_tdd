using System.Collections.Generic;

namespace FizzBuzz.Domain
{
    public class FizzBuzzData
    {
        public List<string> List
        {
            get => _list;
            set => _list = value;
        }

        private List<string> _list;
    }
}