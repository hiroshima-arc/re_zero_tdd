using System;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace ContosoUniversity.Migrations
{
    public partial class Inheritance : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Enrollment_Student_StudentID",
                table: "Enrollment");

            migrationBuilder.DropIndex(name: "IX_Enrollment_StudentID", table: "Enrollment");

            migrationBuilder.RenameTable(name: "Instructor", newName: "Person");
            migrationBuilder.AddColumn<DateTime>(name: "EnrollmentDate", table: "Person", nullable: true);
            migrationBuilder.AddColumn<string>(name: "Discriminator", table: "Person", nullable: false, maxLength: 128,
                defaultValue: "Instructor");
            migrationBuilder.AlterColumn<DateTime>(name: "HireDate", table: "Person", nullable: true);
            migrationBuilder.AddColumn<int>(name: "OldId", table: "Person", nullable: true);

            // Copy existing Student data into new Person table.
            migrationBuilder.Sql(
                "INSERT INTO dbo.Person (LastName, FirstName, HireDate, EnrollmentDate, Discriminator, OldId) SELECT LastName, FirstName, null AS HireDate, EnrollmentDate, 'Student' AS Discriminator, ID AS OldId FROM dbo.Student");
            // Fix up existing relationships to match new PK's.
            migrationBuilder.Sql(
                "UPDATE dbo.Enrollment SET StudentId = (SELECT ID FROM dbo.Person WHERE OldId = Enrollment.StudentId AND Discriminator = 'Student')");

            // Remove temporary key
            migrationBuilder.DropColumn(name: "OldID", table: "Person");

            migrationBuilder.DropTable(
                name: "Student");

            migrationBuilder.CreateIndex(
                name: "IX_Enrollment_StudentID",
                table: "Enrollment",
                column: "StudentID");

            migrationBuilder.AddForeignKey(
                name: "FK_Enrollment_Person_StudentID",
                table: "Enrollment",
                column: "StudentID",
                principalTable: "Person",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
