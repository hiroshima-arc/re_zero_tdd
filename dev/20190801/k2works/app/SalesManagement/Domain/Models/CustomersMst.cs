using System;
using System.Collections.Generic;

namespace SalesManagement.Domain.Models
{
    public sealed class CustomersMst
    {
        public CustomersMst()
        {
            Orders = new HashSet<Orders>();
        }

        public string CustCode { get; set; }
        public decimal CustSubNo { get; set; }
        public decimal? CustType { get; set; }
        public string ArCode { get; set; }
        public decimal? ArSubNo { get; set; }
        public string PayerCode { get; set; }
        public decimal? PayerSubNo { get; set; }
        public string CustName { get; set; }
        public string CustKana { get; set; }
        public string EmpCode { get; set; }
        public string CustUserName { get; set; }
        public string CustUserDepName { get; set; }
        public string CustZipCode { get; set; }
        public string CustState { get; set; }
        public string CustAddress1 { get; set; }
        public string CustAddress2 { get; set; }
        public string CustTel { get; set; }
        public string CustFax { get; set; }
        public string CustEmail { get; set; }
        public decimal? CustArFlag { get; set; }
        public decimal CustCloseDate1 { get; set; }
        public decimal? CustPayMonths1 { get; set; }
        public decimal? CustPayDates1 { get; set; }
        public decimal? CustPayMethod1 { get; set; }
        public decimal CustCloseDate2 { get; set; }
        public decimal? CustPayMonths2 { get; set; }
        public decimal? CustPayDates2 { get; set; }
        public decimal? CustPayMethod2 { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public CompanysMst CustCodeNavigation { get; set; }
        public ICollection<Orders> Orders { get; set; }
    }
}
