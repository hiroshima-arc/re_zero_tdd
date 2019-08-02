using System;

namespace SalesManagement.Domain.Models
{
    public class AutoNumber
    {
        public string SlipType { get; set; }
        public DateTime Yearmonth { get; set; }
        public decimal LastSilpNo { get; set; }
    }
}
