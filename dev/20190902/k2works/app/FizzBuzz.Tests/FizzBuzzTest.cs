using FizzBuzz.Domain;
using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        private Domain.FizzBuzz _fizzBuzzType01;
        private Domain.FizzBuzz _fizzBuzzType02;
        private Domain.FizzBuzz _fizzBuzzType03;

        public FizzBuzzTest()
        {
            _fizzBuzzType01 = new Domain.FizzBuzz(FizzBuzzTypeEnum.One);
            _fizzBuzzType02 = new Domain.FizzBuzz(FizzBuzzTypeEnum.Two);
            _fizzBuzzType03 = new Domain.FizzBuzz(FizzBuzzTypeEnum.Three);
        }
        [Theory]
        [InlineData(0,"1")]
        [InlineData(2,"Fizz")]
        [InlineData(4,"Buzz")]
        [InlineData(14,"FizzBuzz")]
        [InlineData(99,"Buzz")]
        public void 値を1から100までプリントする(int input, string expected)
        {
            _fizzBuzzType01.GenerateList();
            Assert.Equal(expected, _fizzBuzzType01.List[input]);
        }
        [Fact]
        public void 値が3で割り切る場合はFizzをプリントする()
        {
           Assert.Equal("Fizz", _fizzBuzzType01.Generate(3)); 
        }
        [Fact]
        public void 値が5で割り切る場合はBuzzをプリントする()
        {
            Assert.Equal("Buzz", _fizzBuzzType01.Generate(5));
        }
        [Fact]
        public void 値が15で割り切る場合はFizzBuzzをプリントする()
        {
            Assert.Equal("FizzBuzz", _fizzBuzzType01.Generate(15));
        }
        [Fact]
        public void タイプ1は通常のパターンを返す()
        {
            Assert.Equal("Fizz", _fizzBuzzType01.Generate(3));
        }
        [Fact]
        public void タイプ1は通常のパターンのリストを返す()
        {
            _fizzBuzzType01.GenerateList();
            Assert.Equal("Fizz", _fizzBuzzType01.List[2]);
        }

        [Fact]
        public void タイプ2は数のみのパターンを返す()
        {
            Assert.Equal("3", _fizzBuzzType02.Generate(3));
        }

        [Fact]
        public void タイプ2は数のみのパターンのリストを返す()
        {
            _fizzBuzzType02.GenerateList();
            Assert.Equal("3", _fizzBuzzType02.List[2]);
        }
        [Theory]
        [InlineData(15, "FizzBuzz")]
        [InlineData(3, "3")]
        public void タイプ3は15で割り切る場合にFizzBuzzのパターンを返す(int input, string expected)
        {
            Assert.Equal(expected, _fizzBuzzType03.Generate(input));
        }
        [Theory]
        [InlineData(14, "FizzBuzz")]
        [InlineData(2, "3")]
        public void タイプ3は数のみのパターンのリストを返す(int input, string expected)
        {
            _fizzBuzzType03.GenerateList();
            Assert.Equal(expected, _fizzBuzzType03.List[input]);
        }
    }
}
