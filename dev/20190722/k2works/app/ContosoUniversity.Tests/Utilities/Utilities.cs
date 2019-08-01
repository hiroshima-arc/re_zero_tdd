using ContosoUniversity.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace ContosoUniversity.Tests.Utilities
{
    public static class Utilities
    {
        #region snippet1
        public static DbContextOptions<SchoolContext> TestDbContextOptions()
        {
            // Create a new service provider to create a new in-memory database.
            var serviceProvider = new ServiceCollection()
                .AddEntityFrameworkInMemoryDatabase()
                .BuildServiceProvider();

            // Create a new options instance using an in-memory database and 
            // IServiceProvider that the context should resolve all of its 
            // services from.
            var builder = new DbContextOptionsBuilder<SchoolContext>()
                .UseInMemoryDatabase("InMemoryDb")
                .UseInternalServiceProvider(serviceProvider);

            return builder.Options;
        }
        #endregion
    }
}