using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using FizzBuzz.Application.Service;
using FizzBuzz.Domain.Model;
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

        [HttpGet("[action]/{number:int}")]
        public List<IFizzBuzz> GenerateList(int number)
        {
            var service = FizzBuzzServiceFactory.CreateGenerateListService(FizzBuzzType.One);
            var list = service.GenerateList(number);
            return list.GetList();
        }
    }
}