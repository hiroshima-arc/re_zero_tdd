using FizzBuzz.Application.Service;
using FizzBuzz.Domain.Type;
using Microsoft.AspNetCore.Mvc;

namespace FizzBuzz.Controllers
{
    [Route("api/[controller]")]
    public class FizzBuzzController: Controller
    {
        [HttpGet("[action]/{number:int}")]
        public IFizzBuzz Generate(int number)
        {
            var service = FizzBuzzServiceFactory.CreateGenerateService(FizzBuzzType.One);
            return service.Generate(number);
        }
    }
}