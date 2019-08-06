using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using SalesManagement.Domain.Models.ManagementResources.Department;

namespace SalesManagement.Pages.ManagementResources.Departments
{
    public class DeleteModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public DeleteModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        [BindProperty]
        public DeptMst DeptMst { get; set; }

        public async Task<IActionResult> OnGetAsync(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            DeptMst = await _context.DeptMst.FirstOrDefaultAsync(m => m.DeptCode == id);

            if (DeptMst == null)
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

            DeptMst = await _context.DeptMst.FindAsync(id);

            if (DeptMst != null)
            {
                _context.DeptMst.Remove(DeptMst);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
