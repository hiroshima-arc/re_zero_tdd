using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Employee
{
    public class IndexModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public IndexModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        public IList<Domain.Models.ManagementResources.Employee.Employee> Employee { get;set; }

        public async Task OnGetAsync()
        {
            Employee = await _context.Employee.ToListAsync();
        }
    }
}
