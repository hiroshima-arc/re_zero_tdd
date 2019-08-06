using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using SalesManagement.Domain.Models.ManagementResources.Department;

namespace SalesManagement.Pages.ManagementResources.Departments
{
    public class EditModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public EditModel(Infrastructure.SalesContext context)
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

        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            _context.Attach(DeptMst).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DeptMstExists(DeptMst.DeptCode))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return RedirectToPage("./Index");
        }

        private bool DeptMstExists(string id)
        {
            return _context.DeptMst.Any(e => e.DeptCode == id);
        }
    }
}
