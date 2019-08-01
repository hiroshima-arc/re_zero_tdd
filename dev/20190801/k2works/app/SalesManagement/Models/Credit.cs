using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Credit
    {
        public string CreditNo { get; set; }
        public DateTime? CreditDate { get; set; }
        public string DeptCode { get; set; }
        public DateTime? StartDate { get; set; }
        public string CompCode { get; set; }
        public decimal? CompSubNo { get; set; }
        public decimal? PayMethodType { get; set; }
        public decimal? ReceivedAmnt { get; set; }
        public decimal? Received { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public DateTime? UpdatePlgDate { get; set; }
        public string UpdatePgm { get; set; }
        public string BankAcutCode { get; set; }

        public virtual DeptMst DeptMst { get; set; }
    }
}
