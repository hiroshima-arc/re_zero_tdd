using System;
using System.Collections.Generic;

namespace SalesManagement.Domain.Models.ManagementResources.Department
{
    public sealed class DeptMst
    {
        public DeptMst()
        {
            BankAcutMst = new HashSet<BankAcutMst>();
            Credit = new HashSet<Credit>();
            Pay = new HashSet<Pay>();
            Pu = new HashSet<Pu>();
            WhDeptMst = new HashSet<WhDeptMst>();
        }

        public string DeptCode { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime? EndDate { get; set; }
        public string DepName { get; set; }
        public decimal Layer { get; set; }
        public string UpDivisionCode { get; set; }
        public decimal? SlitYn { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public ICollection<BankAcutMst> BankAcutMst { get; set; }
        public ICollection<Credit> Credit { get; set; }
        public ICollection<Pay> Pay { get; set; }
        public ICollection<Pu> Pu { get; set; }
        public ICollection<WhDeptMst> WhDeptMst { get; set; }
    }
}
