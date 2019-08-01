using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Departments
{
    public class CreateModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public CreateModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        public IActionResult OnGet()
        {
        ViewData["InstructorID"] = new SelectList(_unitOfWork.Context.Instructors, "ID", "FirstMidName");
            return Page();
        }

        [BindProperty]
        public Department Department { get; set; }

        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            _unitOfWork.DepartmentRepository.Insert(Department);
            await _unitOfWork.Save();

            return RedirectToPage("./Index");
        }
    }
}