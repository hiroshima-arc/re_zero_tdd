using System;
using SalesManagement.Domain.Models.ManagementResources;
using SalesManagement.Domain.Models.ManagementResources.Product;

namespace SalesManagement.Domain.Models
{
    public class PuDetails
    {
        public decimal PuRowNo { get; set; }
        public decimal PuRowDspNo { get; set; }
        public decimal PoRowNo { get; set; }
        public string ProdCode { get; set; }
        public string WhCode { get; set; }
        public string ProdName { get; set; }
        public decimal? PoPrice { get; set; }
        public decimal PuQuantity { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public string PuNo { get; set; }

        public virtual Products ProdCodeNavigation { get; set; }
        public virtual Pu PuNoNavigation { get; set; }
        public virtual WhMst WhCodeNavigation { get; set; }
    }
}
