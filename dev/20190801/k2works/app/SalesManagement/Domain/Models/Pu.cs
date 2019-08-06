using System;
using System.Collections.Generic;
using SalesManagement.Domain.Models.ManagementResources.Department;
using SalesManagement.Domain.Models.ManagementResources.Employee;

namespace SalesManagement.Domain.Models
{
    public sealed class Pu
    {
        public Pu()
        {
            PuDetails = new HashSet<PuDetails>();
        }

        public string PuNo { get; set; }
        public DateTime? PuDate { get; set; }
        public string SupCode { get; set; }
        public decimal? SupSubNo { get; set; }
        public string EmpCode { get; set; }
        public string DeptCode { get; set; }
        public decimal? PuAmmount { get; set; }
        public decimal CmpTax { get; set; }
        public string SlipComment { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public DateTime? StartDate { get; set; }
        public string PoNo { get; set; }

        public DeptMst DeptMst { get; set; }
        public Employee EmpCodeNavigation { get; set; }
        public ICollection<PuDetails> PuDetails { get; set; }
    }
}
