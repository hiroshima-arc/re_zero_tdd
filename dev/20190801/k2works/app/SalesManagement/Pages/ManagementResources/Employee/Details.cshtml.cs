using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Employee
{
    public class DetailsModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public DetailsModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        public Domain.Models.ManagementResources.Employee.Employee Employee { get; set; }

        public async Task<IActionResult> OnGetAsync(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Employee = await _context.Employee.FirstOrDefaultAsync(m => m.EmpCode == id);

            if (Employee == null)
            {
                return NotFound();
            }
            return Page();
        }
    }
}
