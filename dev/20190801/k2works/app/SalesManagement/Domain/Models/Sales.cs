using System;
using System.Collections.Generic;

namespace SalesManagement.Domain.Models
{
    public sealed class Sales
    {
        public Sales()
        {
            SalesDetails = new HashSet<SalesDetails>();
        }

        public string SalesNo { get; set; }
        public string OrderNo { get; set; }
        public DateTime SalesDate { get; set; }
        public decimal? SalesType { get; set; }
        public string DeptCode { get; set; }
        public string CompCode { get; set; }
        public string EmpCode { get; set; }
        public decimal SalesAmnt { get; set; }
        public decimal CmpTax { get; set; }
        public string SlipComment { get; set; }
        public decimal? UpdatedNo { get; set; }
        public string OrgnlNo { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public ICollection<SalesDetails> SalesDetails { get; set; }
    }
}
