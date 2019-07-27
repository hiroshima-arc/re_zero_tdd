using System.Linq;
using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Students
{
    public class EditModel : PageModel
    {
        private readonly IStudentRepository _repository;

        public EditModel(IStudentRepository context)
        {
            _repository = context;
        }

        [BindProperty]
        public Student Student { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Student = await _repository.GetStudentByID(id);

            if (Student == null)
            {
                return NotFound();
            }
            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            var studentToUpdate = await _repository.GetStudentByID(id);

            if (await TryUpdateModelAsync<Student>(
                studentToUpdate,
                "student",
                s => s.FirstMidName, s => s.LastName, s => s.Enrollments))
            {
                await _repository.Save();
                return RedirectToPage("./Index");
            }

            return Page();

        }

        private bool StudentExists(int id)
        {
            return _repository.GetStudents().Any(e => e.ID == id);
        }
    }
}
