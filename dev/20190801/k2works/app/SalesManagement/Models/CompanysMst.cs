using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class CompanysMst
    {
        public CompanysMst()
        {
            CustomersMst = new HashSet<CustomersMst>();
            Pricebycustomer = new HashSet<Pricebycustomer>();
            SupplierMst = new HashSet<SupplierMst>();
        }

        public string CompCode { get; set; }
        public string CompName { get; set; }
        public string CompKana { get; set; }
        public decimal? SupType { get; set; }
        public string ZipCode { get; set; }
        public string State { get; set; }
        public string Address1 { get; set; }
        public string Address2 { get; set; }
        public decimal? NoSalesFlg { get; set; }
        public decimal? WideUseType { get; set; }
        public string CompGroupCode { get; set; }
        public decimal? MaxCredit { get; set; }
        public decimal? TempCreditUp { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual CreditBalance CreditBalance { get; set; }
        public virtual ICollection<CustomersMst> CustomersMst { get; set; }
        public virtual ICollection<Pricebycustomer> Pricebycustomer { get; set; }
        public virtual ICollection<SupplierMst> SupplierMst { get; set; }
    }
}
