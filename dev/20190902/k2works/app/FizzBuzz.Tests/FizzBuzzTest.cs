using FizzBuzz.Domain;
using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        private Domain.FizzBuzz _fizzBuzz;

        public FizzBuzzTest()
        {
            _fizzBuzz = new Domain.FizzBuzz();
        }
        [Theory]
        [InlineData(0,"1")]
        [InlineData(2,"Fizz")]
        [InlineData(4,"Buzz")]
        [InlineData(14,"FizzBuzz")]
        [InlineData(99,"Buzz")]
        public void 値を1から100までプリントする(int input, string expected)
        {
            _fizzBuzz.GenerateList();
            Assert.Equal(expected, _fizzBuzz.List[input]);
        }
        [Fact]
        public void 値が3で割り切る場合はFizzをプリントする()
        {
           Assert.Equal("Fizz", _fizzBuzz.Generate(3)); 
        }
        [Fact]
        public void 値が5で割り切る場合はBuzzをプリントする()
        {
            Assert.Equal("Buzz", _fizzBuzz.Generate(5));
        }
        [Fact]
        public void 値が15で割り切る場合はFizzBuzzをプリントする()
        {
            Assert.Equal("FizzBuzz", _fizzBuzz.Generate(15));
        }
        [Fact]
        public void タイプ1は通常のパターンを返す()
        {
            Assert.Equal("Fizz", _fizzBuzz.Generate(3, 1));
        }
        [Fact]
        public void タイプ1は通常のパターンのリストを返す()
        {
            _fizzBuzz.GenerateList(1);
            Assert.Equal("Fizz", _fizzBuzz.List[2]);
        }

        [Fact]
        public void タイプ2は数のみのパターンを返す()
        {
            Assert.Equal("3", _fizzBuzz.Generate(3, 2));
        }

        [Fact]
        public void タイプ2は数のみのパターンのリストを返す()
        {
            _fizzBuzz.GenerateList(2);
            Assert.Equal("3", _fizzBuzz.List[2]);
        }
        [Theory]
        [InlineData(15, 3, "FizzBuzz")]
        [InlineData(3, 3, "3")]
        public void タイプ3は15で割り切る場合にFizzBuzzのパターンを返す(int input1, int input2, string expected)
        {
            Assert.Equal(expected, _fizzBuzz.Generate(input1, input2));
        }
        [Theory]
        [InlineData(14, "FizzBuzz")]
        [InlineData(2, "3")]
        public void タイプ3は数のみのパターンのリストを返す(int input, string expected)
        {
            _fizzBuzz.GenerateList(3);
            Assert.Equal(expected, _fizzBuzz.List[input]);
        }
    }
}
