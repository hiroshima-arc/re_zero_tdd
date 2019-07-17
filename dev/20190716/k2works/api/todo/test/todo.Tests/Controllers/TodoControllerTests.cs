using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Moq;
using todo.Controllers;
using todo.Models;
using todo.Repositories;
using Xunit;

namespace todo.Tests
{
    public class TodoControllerTests
    {
        [Fact(DisplayName = "Todo一覧を返す")]
        public async Task GetTodoItems()
        {
            // Arrange
            var mockRepo = new Mock<ITodoRepository>();
            mockRepo.Setup(repo => repo.SelectAllAsync()).ReturnsAsync(GetTestTodoList);
            var controller = new TodoController(mockRepo.Object);
            
            // Act
            var result = await controller.GetTodoItems();
            
            // Assert
            Assert.Equal(2,result.Value.Count());
            Assert.Equal("Item1", result.Value.First().Name);
            Assert.Equal("Item2", result.Value.Last().Name);
        }

        [Fact(DisplayName = "Todoを追加する")]
        public async Task CreateTodoItme()
        {
            // Arrange
            var mockRepo = new Mock<ITodoRepository>();
            var todo = new TodoItem{Name = "item1"};
            mockRepo.Setup(repo => repo.SaveAsync(todo)).Returns(Task.CompletedTask);
            var controller = new TodoController(mockRepo.Object);
            
            // Act
            var result = await controller.PostTodoItem(todo);
            
            // Assert
            Assert.Null(result.Value);
        }
        
        [Fact(DisplayName = "Todoを削除する")]
        public async Task DeleteTodoItme()
        {
            // Arrange
            var mockRepo = new Mock<ITodoRepository>();
            var todo = new TodoItem{Name = "item1"};
            mockRepo.Setup(repo => repo.DeleteAsync(todo)).Returns(Task.CompletedTask);
            var controller = new TodoController(mockRepo.Object);
            
            // Act
            var result = await controller.PostTodoItem(todo);
            
            // Assert
            Assert.Null(result.Value);
        }
        private List<TodoItem> GetTestTodoList()
        {
            var list = new List<TodoItem>();
            list.Add(new TodoItem()
                {
                    Name = "Item1"
                });
            list.Add(new TodoItem()
            {
                Name = "Item2"
            });
            return list;
        }
    }
}