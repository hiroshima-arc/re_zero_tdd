using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using SalesManagement.Domain.Models.ManagementResources.Department;

namespace SalesManagement.Pages.ManagementResources.Departments
{
    public class IndexModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public IndexModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        public IList<DeptMst> DeptMst { get;set; }

        public async Task OnGetAsync()
        {
            DeptMst = await _context.DeptMst.ToListAsync();
        }
    }
}
