using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Pu
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

        public virtual DeptMst DeptMst { get; set; }
        public virtual Employee EmpCodeNavigation { get; set; }
        public virtual ICollection<PuDetails> PuDetails { get; set; }
    }
}
