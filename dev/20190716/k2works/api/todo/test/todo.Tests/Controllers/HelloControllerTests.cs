using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using todo.Controllers;
using Xunit;

namespace todo.Tests
{

    public class HelloControllerTests
    {
        [Fact(DisplayName = "JSONオブジェクトを返す")]
        public void Get_Returns_JSON_Value()
        {
            // Arrange
            var controller = new HelloController();
            
            // Act
            var okResult = controller.Get();
            
            // Assert
            Assert.IsType<Dictionary<string,string>>(okResult);
            Assert.Equal(1, okResult.Count);
            Assert.Equal("hello, world", okResult["Output"]);
        }
    }
}