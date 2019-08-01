using System.Linq;
using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Departments
{
    public class EditModel : PageModel
    {
        private readonly UnitOfWork _unitOfWork;

        public EditModel(UnitOfWork context)
        {
            _unitOfWork = context;
        }

        [BindProperty]
        public Department Department { get; set; }
        // Replace ViewData["InstructorID"]
        public SelectList InstructorNameSL { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            Department = await _unitOfWork.DepartmentRepository.Get(
                    includeProperties:"Administrator",
                    option:m => m.DepartmentID == id);

            if (Department == null)
            {
                return NotFound();
            }
            
            // User strongly typed data rather than ViewData.
            InstructorNameSL = new SelectList(_unitOfWork.Context.Instructors, "ID", "FirstMidName");
            
            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int id)
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            var departmentToUpdate = await _unitOfWork.Context.Departments
                .Include(i => i.Administrator)
                .FirstOrDefaultAsync(m => m.DepartmentID == id);
            
            // null means Department was deleted by another user.
            if (departmentToUpdate == null)
            {
                return HandleDeletedDepartment();
            }
            
            // Update the RowVersion to the value when this entity was
            // fetched. If the entity has been updated after it was
            // fetched, RowVersion won't match the DB RowVersion and
            // a DbUpdateConcurrencyException is thrown.
            // A second postback will make them match, unless a new
            // concurrency issue happens.
            _unitOfWork.Context.Entry(departmentToUpdate).Property("RowVersion").OriginalValue = Department.RowVersion;

            if (await TryUpdateModelAsync<Department>(
                departmentToUpdate,
                "Department",
                s => s.Name, s => s.StartDate, s => s.Budget, s => s.InstructorID))
            {
                try
                {
                    await _unitOfWork.Save();
                    return RedirectToPage("./Index");
                }
                catch (DbUpdateConcurrencyException ex)
                {
                    var exceptionEntry = ex.Entries.Single();
                    var clientValues = (Department) exceptionEntry.Entity;
                    var databaseEntry = exceptionEntry.GetDatabaseValues();
                    if (databaseEntry == null)
                    {
                        ModelState.AddModelError(string.Empty, "Unable to save. " + "The department was deleted by another user.");
                        return Page();
                    }

                    var dbValues = (Department) databaseEntry.ToObject();
                    await setDbErrorMessage(dbValues, clientValues, _unitOfWork);
                    
                    // Save the current RowVersion so next postback
                    // matches unless an new concurrency issue happens.
                    Department.RowVersion = (byte[]) dbValues.RowVersion;
                    // Must clear the model error for the next postback,
                    ModelState.Remove("Department.RowVersion");
                }
            }
            
            InstructorNameSL = new SelectList(_unitOfWork.Context.Instructors, "ID", "FullName", departmentToUpdate.InstructorID);
            return Page();
        }
        private IActionResult HandleDeletedDepartment()
        {
           var deletedDepartment = new Department();
           // ModelState contains the posted data because of the deletion error and will overide the Department instance values when displaying Page().
           ModelState.AddModelError(string.Empty, "Unable to save. The department was deleted by another user.");
           InstructorNameSL = new SelectList(_unitOfWork.Context.Instructors, "ID", "FullName", Department.InstructorID);
           return Page();
        }
        private async Task setDbErrorMessage(Department dbValues, Department clientValues, UnitOfWork context)
        {
            if (dbValues.Name != clientValues.Name)
            {
                ModelState.AddModelError("Department.Name",$"Currennt value: {dbValues.Name}");
            }
            if (dbValues.Budget != clientValues.Budget)
            {
                ModelState.AddModelError("Department.Budget",$"Current value: {dbValues.Budget:c}");
            }
            if (dbValues.StartDate != clientValues.StartDate)
            {
                ModelState.AddModelError("Department.StartDate",$"Current value: {dbValues.StartDate:c}");
            }
            if (dbValues.InstructorID != clientValues.InstructorID)
            {
                Instructor dbInstructor = await _unitOfWork.Context.Instructors
                    .FindAsync(dbValues.InstructorID);
                ModelState.AddModelError("Department.InstructorID", $"Current value: {dbInstructor?.FullName}");
            }
            
            ModelState.AddModelError(string.Empty,
                "The record you attempted to edit "
                + "was modified by another user after you. The "
                + "edit operation was canceled and the current values in the database "
                + "have been displayed. If you still want to edit this record, click"
                + "the Save button again.");
        }
    }
}
