using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Courses
{
    public class EditModel : DepartmentNamePageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public EditModel(UnitOfWork context)
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

            Course = await _unitOfWork.CourseRepository.Get(
                includeProperties: "Department",
                option: m => m.CourseID == id
            );

            if (Course == null)
            {
                return NotFound();
            }
            // Select current DepartmentID
            PopulateDepartmentsDropDownList(_unitOfWork.Context, Course.DepartmentID);
            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            var courseToUpdate = await _unitOfWork.CourseRepository.GetByID(id);

            if (await TryUpdateModelAsync<Course>(
                courseToUpdate,
                "course", // Prefix for form value.
                c => c.Credits, c => c.DepartmentID, c => c.Title))
            {
                await _unitOfWork.Save();
                return RedirectToPage("./Index");
            }
            
            // Select DepartmentID if TryUpdateModelAsync fails.
            PopulateDepartmentsDropDownList(_unitOfWork.Context, courseToUpdate.DepartmentID);
            return Page();
        }
    }
}
