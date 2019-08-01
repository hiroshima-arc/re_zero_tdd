using System.Collections.Generic;
using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc.RazorPages;
using ContosoUniversity.Models;
using Microsoft.EntityFrameworkCore;

namespace ContosoUniversity.Pages.Departments
{
    public class IndexModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public IndexModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        public IList<Department> Department { get;set; }

        public async Task OnGetAsync()
        {
            Department = await _unitOfWork.DepartmentRepository.dbSet.Include(d => d.Administrator).ToListAsync();
        }
    }
}
