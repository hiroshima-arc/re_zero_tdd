using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Courses
{
    public class CreateModel : DepartmentNamePageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public CreateModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        public IActionResult OnGet()
        {
            PopulateDepartmentsDropDownList(_unitOfWork.Context);
            return Page();
        }

        [BindProperty]
        public Course Course { get; set; }

        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }
            
            var emptyCourse = new Course();

            if (await TryUpdateModelAsync<Course>(emptyCourse,
                "course", // Prefix for form value
                s => s.CourseID, s => s.DepartmentID, s => s.Title, s => s.Credits))
            {
                _unitOfWork.CourseRepository.Insert(emptyCourse);
                await _unitOfWork.Save();
                return RedirectToPage("./Index");
            }
            
            // Select DepartmentID if TryUpdateModelAsync fails.
            PopulateDepartmentsDropDownList(_unitOfWork.Context, emptyCourse.Department);
            return Page();
        }
    }
}