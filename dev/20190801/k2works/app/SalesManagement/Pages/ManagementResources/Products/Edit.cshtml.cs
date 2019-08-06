using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Products
{
    public class EditModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public EditModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        [BindProperty]
        public Domain.Models.ManagementResources.Product.Products Products { get; set; }

        public async Task<IActionResult> OnGetAsync(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Products = await _context.Products.FirstOrDefaultAsync(m => m.ProdCode == id);

            if (Products == null)
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

            _context.Attach(Products).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ProductsExists(Products.ProdCode))
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

        private bool ProductsExists(string id)
        {
            return _context.Products.Any(e => e.ProdCode == id);
        }
    }
}
