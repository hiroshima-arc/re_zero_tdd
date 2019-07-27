using System.Collections.Generic;
using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Courses
{
    public class DetailsModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public DetailsModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        public Course Course { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Course = await _unitOfWork.CourseRepository.Get(
                includeProperties: "Department",
                option: m => m.CourseID == id
                );

            if (Course == null)
            {
                return NotFound();
            }
            return Page();
        }
    }
}
