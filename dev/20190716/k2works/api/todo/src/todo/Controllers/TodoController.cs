using System.Linq;
using Microsoft.AspNetCore.Mvc;
using todo.Models;

namespace todo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TodoController : ControllerBase
    {
        private readonly TodoContext _context;

        public TodoController(TodoContext context)
        {
            _context = context;

            if (_context.TodoItems.Count() == 0)
            {
                _context.TodoItems.Add(new TodoItem {Name = "Item1"});
                _context.SaveChanges();
            }
        }

    }
}