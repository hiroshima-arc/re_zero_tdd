using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class AutoNumber
    {
        public string SlipType { get; set; }
        public DateTime Yearmonth { get; set; }
        public decimal LastSilpNo { get; set; }
    }
}
