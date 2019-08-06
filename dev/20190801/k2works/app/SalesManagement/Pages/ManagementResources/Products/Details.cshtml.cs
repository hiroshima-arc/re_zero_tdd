using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Products
{
    public class DetailsModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public DetailsModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

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
    }
}
