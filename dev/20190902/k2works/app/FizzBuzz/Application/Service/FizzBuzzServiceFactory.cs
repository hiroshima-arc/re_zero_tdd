using FizzBuzz.Application.Command;

namespace FizzBuzz.Application.Service
{
    public static class FizzBuzzServiceFactory
    {
        public static FizzBuzzService CreateGenerateService(IFizzBuzzType type)
        {
            return new FizzBuzzService(new FizzBuzzValueCommand(type));
        }

        public static FizzBuzzService CreateGenerateListService(IFizzBuzzType type)
        {
            return new FizzBuzzService(new FizzBuzzListCommand(type));
        }
    }
}