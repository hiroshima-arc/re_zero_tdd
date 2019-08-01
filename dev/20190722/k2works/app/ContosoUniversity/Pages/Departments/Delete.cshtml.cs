using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Departments
{
    public class DeleteModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public DeleteModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        [BindProperty] public Department Department { get; set; }
        public string ConcurrencyErrorMessage { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id, bool? concurrencyError)
        {
            Department = await _unitOfWork.DepartmentRepository.Get(
                    includeProperties:"Administrator",
                    option: m => m.DepartmentID == id);

            if (Department == null)
            {
                return NotFound();
            }

            if (concurrencyError.GetValueOrDefault())
            {
                ConcurrencyErrorMessage = "The record you attempted to delete "
                                          + "was modified by another user after you selected delete. "
                                          + "The delete operation was canceled and the current values in the "
                                          + "database have been displayed. If you still want to delete this "
                                          + "record, click the Delete button again.";
            }

            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            try
            {
                if (await _unitOfWork.Context.Departments.AnyAsync(
                    m => m.DepartmentID == id))
                {
                    // Department.rowVersion value is from when the entity
                    // was fetched. If it doesn't match the DB, a
                    // DbUpdateConcurrencyException exception is thrown.
                    _unitOfWork.DepartmentRepository.Delete(Department);
                    await _unitOfWork.Save();
                }

                return RedirectToPage("./Index");
            }
            catch (DbUpdateConcurrencyException)
            {
                return RedirectToPage("./Delete",
                    new {concurrencyError = true, id = id});
            }
        }
    }
}