using System;

namespace SalesManagement.Domain.Models
{
    public class BankAcutMst
    {
        public string BankAcutCode { get; set; }
        public string ReciveActName { get; set; }
        public DateTime? ApplStartDate { get; set; }
        public DateTime? ApplEndDate { get; set; }
        public string StartActName { get; set; }
        public string ReciveBankActType { get; set; }
        public string ReciveActNo { get; set; }
        public string BankActType { get; set; }
        public string ActName { get; set; }
        public string DeptCode { get; set; }
        public DateTime? StartDate { get; set; }
        public string ABankCode { get; set; }
        public string ABankBlncCode { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public DateTime? UpdatePlgDate { get; set; }
        public string UpdatePgm { get; set; }

        public virtual DeptMst DeptMst { get; set; }
    }
}
