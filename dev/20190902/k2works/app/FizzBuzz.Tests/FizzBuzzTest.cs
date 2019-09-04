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
    }
}
