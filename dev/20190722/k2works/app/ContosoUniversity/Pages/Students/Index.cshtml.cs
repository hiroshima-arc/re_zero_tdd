using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using ContosoUniversity.Models;
using Microsoft.EntityFrameworkCore.Query.ExpressionTranslators.Internal;

namespace ContosoUniversity.Pages.Students
{
    public class IndexModel : PageModel
    {
        private readonly ContosoUniversity.Models.SchoolContext _context;

        public IndexModel(ContosoUniversity.Models.SchoolContext context)
        {
            _context = context;
        }
        
        public string NameSort { get; set; }
        public string DateSort { get; set; }
        public string CurrentFilter { get; set; }
        public string CurrentSort { get; set; }

        public IList<Student> Student { get;set; }

        public async Task OnGetAsync(string sortOrder)
        {
            NameSort = String.IsNullOrEmpty(sortOrder) ? "name_desc" : "";
            DateSort = sortOrder == "Date" ? "date_desc" : "Date";

            IQueryable<Student> studentIQ = from s in _context.Student select s;

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

            Student = await studentIQ.AsNoTracking().ToListAsync();
        }
    }
}
