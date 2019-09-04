using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        [Fact]
        public void 値を1から100までプリントする()
        {
            var list = Domain.FizzBuzz.GenerateList();
            Assert.Equal(1, list[0]);
            Assert.Equal(100, list[99]);
        }
        [Fact]
        public void 値が3で割り切る場合はFizzをプリントする()
        {
           Assert.Equal("Fizz", Domain.FizzBuzz.Generate(3)); 
        }
        [Fact]
        public void 値が5で割り切る場合はBuzzをプリントする()
        {
            Assert.Equal("Buzz", Domain.FizzBuzz.Generate(5));
        }

        [Fact]
        public void 値が15で割り切る場合はFizzBuzzをプリントする()
        {
            Assert.Equal("FizzBuzz", Domain.FizzBuzz.Generate(15));
        }
    }
}
