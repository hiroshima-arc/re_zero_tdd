using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Pay
    {
        public string PayNo { get; set; }
        public decimal? PayDate { get; set; }
        public string DeptCode { get; set; }
        public string SupCode { get; set; }
        public decimal? SupSubNo { get; set; }
        public decimal? PayMethodType { get; set; }
        public decimal? PayAmnt { get; set; }
        public decimal CmpTax { get; set; }
        public decimal CompleteFlg { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public DateTime? StartDate { get; set; }

        public virtual DeptMst DeptMst { get; set; }
        public virtual SupplierMst Sup { get; set; }
    }
}
