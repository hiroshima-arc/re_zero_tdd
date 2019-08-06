using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Products
{
    public class DeleteModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public DeleteModel(Infrastructure.SalesContext context)
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

        public async Task<IActionResult> OnPostAsync(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Products = await _context.Products.FindAsync(id);

            if (Products != null)
            {
                _context.Products.Remove(Products);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
