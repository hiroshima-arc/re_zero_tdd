using System;
using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        [Fact]
        public void 値を1から100までプリントする()
        {
            Assert.Equal(1, Domain.FizzBuzz.Print1From100());
        }
    }
}
