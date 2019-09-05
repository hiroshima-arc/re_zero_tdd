namespace FizzBuzz.Domain
{
    public class FizzBuzzType02
    {
        private readonly int _number;

        public FizzBuzzType02(int number)
        {
            _number = number;
        }

        public string Generate()
        {
            return _number.ToString();
        }
    }
}