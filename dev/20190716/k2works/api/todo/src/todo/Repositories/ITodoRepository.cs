using System.Collections.Generic;
using System.Threading.Tasks;
using todo.Models;

namespace todo.Repositories
{
    public interface ITodoRepository
    {
        Task<List<TodoItem>> SelectAllAsync();

        Task<TodoItem> FindAsync(long id);

        Task SaveAsync(TodoItem item);

        Task UpdateAsync(TodoItem item);

        Task DeleteAsync(TodoItem item);

        void Save();
    }
}