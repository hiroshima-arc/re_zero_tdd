using System;
using System.Collections.Generic;
using FizzBuzz.Application.Command;
using FizzBuzz.Application.Service;
using FizzBuzz.Domain.Type;
using Xunit;

namespace FizzBuzz.Tests
{
    public class FizzBuzzTest
    {
        private FizzBuzzService _serviceType01;
        private FizzBuzzService _serviceType02;
        private FizzBuzzService _serviceType03;

        public FizzBuzzTest()
        {
            _serviceType01 = new FizzBuzzService(new FizzBuzzValueCommand(FizzBuzzType.One));
            _serviceType02 = new FizzBuzzService(new FizzBuzzValueCommand(FizzBuzzType.Two));
            _serviceType03 = new FizzBuzzService(new FizzBuzzValueCommand(FizzBuzzType.Three));
        }
        [Theory]
        [InlineData(0,"1")]
        [InlineData(2,"Fizz")]
        [InlineData(4,"Buzz")]
        [InlineData(14,"FizzBuzz")]
        [InlineData(99,"Buzz")]
        public void 値を1から100までプリントする(int input, string expected)
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.One);
            Assert.Equal(expected, command.Execute(100).GetList()[input].GetValue());
        }
        [Fact]
        public void 値が3で割り切る場合はFizzをプリントする()
        {
           Assert.Equal("Fizz", _serviceType01.Generate(3).GetValue()); 
        }
        [Fact]
        public void 値が5で割り切る場合はBuzzをプリントする()
        {
            Assert.Equal("Buzz", _serviceType01.Generate(5).GetValue());
        }
        [Fact]
        public void 値が15で割り切る場合はFizzBuzzをプリントする()
        {
            Assert.Equal("FizzBuzz", _serviceType01.Generate(15).GetValue());
        }
        [Fact]
        public void タイプ1は通常のパターンを返す()
        {
            Assert.Equal("Fizz", _serviceType01.Generate(3).GetValue());
        }
        [Fact]
        public void タイプ1は通常のパターンのリストを返す()
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.One);
            Assert.Equal("Fizz", command.Execute(3).GetList()[2].GetValue());
        }

        [Fact]
        public void タイプ2は数のみのパターンを返す()
        {
            Assert.Equal("3", _serviceType02.Generate(3).GetValue());
        }

        [Fact]
        public void タイプ2は数のみのパターンのリストを返す()
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.Two);
            Assert.Equal("3", command.Execute(3).GetList()[2].GetValue());
        }
        [Theory]
        [InlineData(15, "FizzBuzz")]
        [InlineData(3, "3")]
        public void タイプ3は15で割り切る場合にFizzBuzzのパターンを返す(int input, string expected)
        {
            Assert.Equal(expected, _serviceType03.Generate(input).GetValue());
        }
        [Theory]
        [InlineData(14, "FizzBuzz")]
        [InlineData(2, "3")]
        public void タイプ3は数のみのパターンのリストを返す(int input, string expected)
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.Three);
            Assert.Equal(expected, command.Execute(15).GetList()[input].GetValue());
        }

        [Fact]
        public void FizzBuzzValueはNullオブジェクトを返す()
        {
            var fizzBuzz = _serviceType01.Generate(3);
            var empy = new List<IFizzBuzz>();
            Assert.Equal(empy, fizzBuzz.GetList());
        }

        [Fact]
        public void FizzBuzzListはNullオブジェクトを返す()
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.One);
            Assert.Equal("", command.Execute(3).GetValue());
        }

        [Fact]
        public void FizzBuzzValueの値は正の値のみ許可する()
        {
            Assert.Throws<ArgumentException>(() => _serviceType01.Generate(-1));
        }
        [Fact]
        public void FizzBuzzListの値は正の値のみ許可する()
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.One);
            Assert.Throws<ArgumentException>(() => command.Execute(-1));
        }
        [Fact]
        public void FizzBuzzListの値は101以上を許可しない()
        {
            var command = new FizzBuzzListCommand(FizzBuzzType.One);
            Assert.Throws<ArgumentException>(() => command.Execute(101));
        }
    }
}
