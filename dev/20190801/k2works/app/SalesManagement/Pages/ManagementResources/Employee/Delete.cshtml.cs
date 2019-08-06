using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Employee
{
    public class DeleteModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public DeleteModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        [BindProperty]
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

        public async Task<IActionResult> OnPostAsync(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Employee = await _context.Employee.FindAsync(id);

            if (Employee != null)
            {
                _context.Employee.Remove(Employee);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
