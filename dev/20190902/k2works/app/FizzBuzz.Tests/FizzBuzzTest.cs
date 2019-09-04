using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        [Fact]
        public void 値を1から100までプリントする()
        {
            var list = Domain.FizzBuzz.Print1From100();
            Assert.Equal(1, list[0]);
            Assert.Equal(100, list[99]);
        }

        [Fact]
        public void 値が3で割り切る場合はFizzをプリントする()
        {
           Assert.Equal("Fizz", Domain.FizzBuzz.Generate(3)); 
        }
    }
}
