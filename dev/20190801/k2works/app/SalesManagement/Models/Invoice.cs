using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Invoice
    {
        public Invoice()
        {
            InvoiceDetails = new HashSet<InvoiceDetails>();
        }

        public string InvoiceNo { get; set; }
        public DateTime? InvoicedDate { get; set; }
        public string CompCode { get; set; }
        public decimal? CustSubNo { get; set; }
        public decimal? LastReceived { get; set; }
        public decimal? MonthSales { get; set; }
        public decimal? MonthReceived { get; set; }
        public decimal? MonthInvoice { get; set; }
        public decimal CmpTax { get; set; }
        public decimal? InvoiceReceived { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual ICollection<InvoiceDetails> InvoiceDetails { get; set; }
    }
}
