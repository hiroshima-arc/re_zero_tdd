using System;
using System.Linq;
using System.Threading.Tasks;
using ContosoUniversity.DAL;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;

namespace ContosoUniversity.Pages.Students
{
    public class IndexModel : PageModel
    {
        private readonly IStudentRepository _repository;

        public IndexModel(IStudentRepository context)
        {
            _repository = context;
        }
        
        public string NameSort { get; set; }
        public string DateSort { get; set; }
        public string CurrentFilter { get; set; }
        public string CurrentSort { get; set; }

        public PaginatedList<Student> Student { get;set; }

        public async Task OnGetAsync(string sortOrder, string currentFilter, string searchString, int? pageIndex)
        {
            CurrentSort = sortOrder;
            NameSort = String.IsNullOrEmpty(sortOrder) ? "name_desc" : "";
            DateSort = sortOrder == "Date" ? "date_desc" : "Date";
            if (searchString != null)
            {
                pageIndex = 1;
            }
            else
            {
                searchString = currentFilter;
            }
            CurrentFilter = searchString;

            IQueryable<Student> studentIQ = from s in _repository.GetStudents() select s;

            if (!String.IsNullOrEmpty(searchString))
            {
                studentIQ = studentIQ.Where(s =>
                    s.LastName.Contains(searchString) || s.FirstMidName.Contains(searchString));
            }

            switch (sortOrder)
            {
            case "name_desc":
                studentIQ = studentIQ.OrderByDescending(s => s.LastName);
                break;
            case "Date":
                studentIQ = studentIQ.OrderBy(s => s.EnrollmentDate);
                break;
            case "date_desc":
                studentIQ = studentIQ.OrderByDescending(s => s.EnrollmentDate);
                break;
            default:
                studentIQ = studentIQ.OrderBy(s => s.LastName);
                break;
            }

            int pageSize = 3;
            Student = await PaginatedList<Student>.CreateAsync(
                studentIQ.AsNoTracking(), pageIndex ?? 1, pageSize);
        }
    }
}
