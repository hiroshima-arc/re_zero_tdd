using System;

namespace SalesManagement.Domain.Models
{
    public class InvoiceDetails
    {
        public string InvoiceNo { get; set; }
        public string SalesNo { get; set; }
        public decimal RowNo { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual Invoice InvoiceNoNavigation { get; set; }
    }
}
