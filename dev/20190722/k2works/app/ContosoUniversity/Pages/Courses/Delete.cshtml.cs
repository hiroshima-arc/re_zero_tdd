using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Courses
{
    public class DeleteModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public DeleteModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        [BindProperty]
        public Course Course { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Course = await _unitOfWork.CourseRepository.Get()
                .AsNoTracking()
                .Include(c => c.Department)
                .FirstOrDefaultAsync(m => m.CourseID == id);

            if (Course == null)
            {
                return NotFound();
            }
            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Course = await _unitOfWork.CourseRepository.Get()
                .AsNoTracking()
                .FirstOrDefaultAsync(m => m.CourseID == id);

            if (Course != null)
            {
                _unitOfWork.CourseRepository.Delete(Course.CourseID);
                await _unitOfWork.Save();
            }

            return RedirectToPage("./Index");
        }
    }
}
