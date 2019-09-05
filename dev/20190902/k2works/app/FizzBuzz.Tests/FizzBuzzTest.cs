using FizzBuzz.Domain;
using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        private Domain.FizzBuzz _fizzBuzzType01;
        private Domain.FizzBuzz _fizzBuzzType02;
        private Domain.FizzBuzz _fizzBuzzType03;
        private FizzBuzzValueCommand _commandType01;
        private FizzBuzzValueCommand _commandType02;
        private FizzBuzzValueCommand _commandType03;

        public FizzBuzzTest()
        {
            _fizzBuzzType01 = new Domain.FizzBuzz(FizzBuzzType.One);
            _fizzBuzzType02 = new Domain.FizzBuzz(FizzBuzzType.Two);
            _fizzBuzzType03 = new Domain.FizzBuzz(FizzBuzzType.Three);
            _commandType01 = new FizzBuzzValueCommand(FizzBuzzType.One);
            _commandType02 = new FizzBuzzValueCommand(FizzBuzzType.Two);
            _commandType03 = new FizzBuzzValueCommand(FizzBuzzType.Three);
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
            Assert.Equal(expected, _fizzBuzzType01.List[input].GetValue());
        }
        [Fact]
        public void 値が3で割り切る場合はFizzをプリントする()
        {
           Assert.Equal("Fizz", _commandType01.Execute(3).GetValue()); 
        }
        [Fact]
        public void 値が5で割り切る場合はBuzzをプリントする()
        {
            Assert.Equal("Buzz", _commandType01.Execute(5).GetValue());
        }
        [Fact]
        public void 値が15で割り切る場合はFizzBuzzをプリントする()
        {
            Assert.Equal("FizzBuzz", _commandType01.Execute(15).GetValue());
        }
        [Fact]
        public void タイプ1は通常のパターンを返す()
        {
            Assert.Equal("Fizz", _commandType01.Execute(3).GetValue());
        }
        [Fact]
        public void タイプ1は通常のパターンのリストを返す()
        {
            _fizzBuzzType01.GenerateList();
            Assert.Equal("Fizz", _fizzBuzzType01.List[2].GetValue());
        }

        [Fact]
        public void タイプ2は数のみのパターンを返す()
        {
            Assert.Equal("3", _commandType02.Execute(3).GetValue());
        }

        [Fact]
        public void タイプ2は数のみのパターンのリストを返す()
        {
            _fizzBuzzType02.GenerateList();
            Assert.Equal("3", _fizzBuzzType02.List[2].GetValue());
        }
        [Theory]
        [InlineData(15, "FizzBuzz")]
        [InlineData(3, "3")]
        public void タイプ3は15で割り切る場合にFizzBuzzのパターンを返す(int input, string expected)
        {
            Assert.Equal(expected, _commandType03.Execute(input).GetValue());
        }
        [Theory]
        [InlineData(14, "FizzBuzz")]
        [InlineData(2, "3")]
        public void タイプ3は数のみのパターンのリストを返す(int input, string expected)
        {
            _fizzBuzzType03.GenerateList();
            Assert.Equal(expected, _fizzBuzzType03.List[input].GetValue());
        }
    }
}
