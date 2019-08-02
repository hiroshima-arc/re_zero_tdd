using System;

namespace SalesManagement.Domain.Models
{
    public class PoDetails
    {
        public decimal PoRowNo { get; set; }
        public decimal PoRowDspNo { get; set; }
        public string OrderNo { get; set; }
        public decimal SoRowNo { get; set; }
        public string ProdCode { get; set; }
        public string ProdName { get; set; }
        public decimal? PoPrice { get; set; }
        public decimal PoQt { get; set; }
        public decimal RecivedQt { get; set; }
        public decimal CompleteFlg { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public string PoNo { get; set; }

        public virtual PurchaseOrders PoNoNavigation { get; set; }
    }
}
