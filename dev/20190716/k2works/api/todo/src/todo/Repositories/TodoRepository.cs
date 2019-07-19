using System.Collections.Generic;
using System.Threading.Tasks;
using todo.Models;
using System.Linq;
using Microsoft.EntityFrameworkCore;

namespace todo.Repositories
{
    public class TodoRepository : ITodoRepository
    {
        private readonly TodoContext _context;

        public TodoRepository(TodoContext todoContext)
        {
            _context = todoContext;
        }
        public async Task<List<TodoItem>> SelectAllAsync()
        {
            return await _context.TodoItems.ToListAsync();
        }

        public async Task<TodoItem> FindAsync(long id)
        {
            return await _context.TodoItems.FindAsync(id);
        }

        public async Task SaveAsync(TodoItem item)
        {
            _context.TodoItems.Add(item);
            await _context.SaveChangesAsync();
        }

        public async Task UpdateAsync(TodoItem item)
        {
            _context.Entry(item).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(TodoItem item)
        {
            _context.TodoItems.Remove(item);
            await _context.SaveChangesAsync();
        }

        public  void Save()
        {
            if (_context.TodoItems.Count() == 0)
            {
                _context.TodoItems.Add(new TodoItem {Name = "Item1"});
                _context.SaveChanges();
            }
        }
    }
}