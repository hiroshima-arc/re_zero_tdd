using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ContosoUniversity.Models;

namespace ContosoUniversity.DAL
{
    public interface IStudentRepository : IDisposable
    {
        IQueryable<Student> GetStudents();
        Task<Student> GetStudentByID(int? studentId);
        void InsertStudent(Student student);
        void DeleteStudent(int studentID);
        void UpdateStudent(Student student);
        Task Save();
    }
}