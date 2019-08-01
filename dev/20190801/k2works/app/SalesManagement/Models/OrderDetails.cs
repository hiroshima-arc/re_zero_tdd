using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class OrderDetails
    {
        public string OrderNo { get; set; }
        public decimal SoRowNo { get; set; }
        public string ProdCode { get; set; }
        public string ProdName { get; set; }
        public decimal Unitprice { get; set; }
        public decimal Quantity { get; set; }
        public decimal? CmpTaxRate { get; set; }
        public decimal? ReserveQty { get; set; }
        public decimal? DeliveryOrderQty { get; set; }
        public decimal? DeliveredQty { get; set; }
        public decimal CompleteFlg { get; set; }
        public decimal Discount { get; set; }
        public DateTime? DeliveryDate { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual Orders OrderNoNavigation { get; set; }
    }
}
