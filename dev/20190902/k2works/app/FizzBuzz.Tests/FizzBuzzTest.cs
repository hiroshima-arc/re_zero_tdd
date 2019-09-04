using FizzBuzz.Domain;
using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        private FizzBuzzData _fizzBuzzData;

        public FizzBuzzTest()
        {
            _fizzBuzzData = new FizzBuzzData();
        }
        [Fact]
        public void 値を1から100までプリントする()
        {
            _fizzBuzzData.List = Domain.FizzBuzz.GenerateList();
            
            Assert.Equal("1", _fizzBuzzData.List[0]);
            Assert.Equal("Fizz", _fizzBuzzData.List[2]);
            Assert.Equal("Buzz", _fizzBuzzData.List[4]);
            Assert.Equal("FizzBuzz", _fizzBuzzData.List[14]);
            Assert.Equal("Buzz", _fizzBuzzData.List[99]);
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
        [Fact]
        public void タイプ1は通常のパターンを返す()
        {
            Assert.Equal("Fizz", Domain.FizzBuzz.Generate(3, 1));
        }
        [Fact]
        public void タイプ1は通常のパターンのリストを返す()
        {
            _fizzBuzzData.List = Domain.FizzBuzz.GenerateList(1);
            Assert.Equal("Fizz", _fizzBuzzData.List[2]);
        }

        [Fact]
        public void タイプ2は数のみのパターンを返す()
        {
            Assert.Equal("3", Domain.FizzBuzz.Generate(3, 2));
        }
    }
}
