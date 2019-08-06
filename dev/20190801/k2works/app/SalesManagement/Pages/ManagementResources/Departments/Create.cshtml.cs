using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using SalesManagement.Domain.Models.ManagementResources.Department;

namespace SalesManagement.Pages.ManagementResources.Departments
{
    public class CreateModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public CreateModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        public IActionResult OnGet()
        {
            return Page();
        }

        [BindProperty]
        public DeptMst DeptMst { get; set; }

        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            _context.DeptMst.Add(DeptMst);
            await _context.SaveChangesAsync();

            return RedirectToPage("./Index");
        }
    }
}