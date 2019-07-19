using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;

namespace todo.Controllers
{
    public class HelloController
    {
        [Route("api/[controller]")]
        [HttpGet]
        public Dictionary<string, string> Get()
        {
            var data = new Dictionary<string, string>();
            data["Output"] = "hello, world";
            return data;
        }
    }
}