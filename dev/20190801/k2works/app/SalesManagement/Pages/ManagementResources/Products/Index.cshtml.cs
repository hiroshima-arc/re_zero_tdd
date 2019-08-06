using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace SalesManagement.Pages.ManagementResources.Products
{
    public class IndexModel : PageModel
    {
        private readonly Infrastructure.SalesContext _context;

        public IndexModel(Infrastructure.SalesContext context)
        {
            _context = context;
        }

        public IList<Domain.Models.ManagementResources.Product.Products> Products { get;set; }

        public async Task OnGetAsync()
        {
            Products = await _context.Products.ToListAsync();
        }
    }
}
