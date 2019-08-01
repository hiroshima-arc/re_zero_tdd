using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class SupplierMst
    {
        public SupplierMst()
        {
            Pay = new HashSet<Pay>();
        }

        public string SupCode { get; set; }
        public decimal SupSubNo { get; set; }
        public string SupName { get; set; }
        public string SupKana { get; set; }
        public string SupEmpName { get; set; }
        public string SupDepName { get; set; }
        public string SupZipCode { get; set; }
        public string SupState { get; set; }
        public string SupAddress1 { get; set; }
        public string SupAddress2 { get; set; }
        public string SupTel { get; set; }
        public string SupFax { get; set; }
        public string SupEmail { get; set; }
        public decimal SupCloseDate { get; set; }
        public decimal? SupPayMonths { get; set; }
        public decimal? SupPayDates { get; set; }
        public decimal? PayMethodType { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual CompanysMst SupCodeNavigation { get; set; }
        public virtual ICollection<Pay> Pay { get; set; }
    }
}
