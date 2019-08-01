using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class SalesDetails
    {
        public string SalesNo { get; set; }
        public decimal RowNo { get; set; }
        public string ProdCode { get; set; }
        public string ProdName { get; set; }
        public decimal Unitprice { get; set; }
        public decimal? DeliveredQty { get; set; }
        public decimal Quantity { get; set; }
        public decimal Discount { get; set; }
        public DateTime? InvoicedDate { get; set; }
        public string InvoiceNo { get; set; }
        public decimal? InvoiceDelayType { get; set; }
        public DateTime? AutoJournalDate { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual Sales SalesNoNavigation { get; set; }
    }
}
