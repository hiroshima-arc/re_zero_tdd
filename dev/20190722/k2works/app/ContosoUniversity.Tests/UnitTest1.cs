using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ContosoUniversity.DAL;
using ContosoUniversity.Models;
using ContosoUniversity.Pages.Students;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Routing;
using Microsoft.AspNetCore.Mvc.ViewFeatures;
using Microsoft.AspNetCore.Routing;
using Microsoft.EntityFrameworkCore;
using Moq;
using Xunit;

namespace ContosoUniversity.Tests
{
    public class UnitTest1
    {
        [Fact]
        public async Task Create_Student_By_DbContext()
        {
            using (var db = new SchoolContext(Utilities.Utilities.TestDbContextOptions()))
            {
                // Arrange
                var student = new Student
                {
                    FirstMidName = "山田",
                    LastName = "太郎"
                };

                // Act
                await db.Students.AddAsync(student);

                // Assert
                var actualStudent = db.Students.FindAsync(1);
                Assert.Equal("太郎, 山田", actualStudent.Result.FullName);
            }
        }

        [Fact]
        public async Task Create_Student_By_Repository()
        {
            using var db = new SchoolContext(Utilities.Utilities.TestDbContextOptions());
            {
                // Arrange
                var repo = new StudentRepository(db);
                var student = new Student
                {
                    FirstMidName = "山田",
                    LastName = "太郎"
                };

                // Act
                repo.InsertStudent(student);
                await repo.Save();


                // Assert
                var actualStudent = repo.GetStudentByID(1);
                Assert.Equal("太郎, 山田", actualStudent.Result.FullName);
            }
        }

        [Fact]
        public async Task Create_Student_Page()
        {
            using var db = new SchoolContext(Utilities.Utilities.TestDbContextOptions());
            {
                // Arrange
                var repo = new StudentRepository(db);
                var dataEntity = new List<Student>
                {
                    new Student {FirstMidName = "山田", LastName = "太郎"},
                    new Student {FirstMidName = "鈴木", LastName = "一郎"}
                };
                dataEntity.ForEach(student => repo.InsertStudent(student));
                await repo.Save();
                var httpContext = new DefaultHttpContext();
                var modelState = new ModelStateDictionary();
                var actionContext =
                    new ActionContext(httpContext, new RouteData(), new PageActionDescriptor(), modelState);
                var modelMetadataProvider = new EmptyModelMetadataProvider();
                var viewData = new ViewDataDictionary(modelMetadataProvider, modelState);
                var tempData = new TempDataDictionary(httpContext, Mock.Of<ITempDataProvider>());
                var pageContext = new PageContext(actionContext)
                {
                    ViewData = viewData
                };
                var pageModel = new IndexModel(repo)
                {
                    PageContext = pageContext,
                    TempData = tempData,
                    Url = new UrlHelper(actionContext)
                };
                pageModel.ModelState.AddModelError("Message.Text", "The Text field is required.");

                // Act
                await pageModel.OnGetAsync("", "", "", null);

                // Assert
                Assert.Equal("一郎, 鈴木", pageModel.Student.First().FullName);
                Assert.Equal("太郎, 山田", pageModel.Student.Last().FullName);
            }
        }
    }
}