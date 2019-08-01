using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Departments
{
    public class DetailsModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public DetailsModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        public Department Department { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Department = await _unitOfWork.DepartmentRepository.Get(
                   includeProperties: "Administrator",
                   option: m => m.DepartmentID == id);

            if (Department == null)
            {
                return NotFound();
            }
            return Page();
        }
    }
}
