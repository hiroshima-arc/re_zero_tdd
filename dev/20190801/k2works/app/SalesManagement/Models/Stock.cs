using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Stock
    {
        public string WhCode { get; set; }
        public string ProdCode { get; set; }
        public string RotNo { get; set; }
        public string StockType { get; set; }
        public string QualityType { get; set; }
        public decimal Actual { get; set; }
        public decimal Valid { get; set; }
        public DateTime? LastDeliveryDate { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual WhMst WhCodeNavigation { get; set; }
    }
}
