using System;
using System.Collections.Generic;

namespace SalesManagement.Domain.Models
{
    public sealed class Products
    {
        public Products()
        {
            LocationMst = new HashSet<LocationMst>();
            PuDetails = new HashSet<PuDetails>();
        }

        public string ProdCode { get; set; }
        public string ProdFullname { get; set; }
        public string ProdName { get; set; }
        public string ProdKana { get; set; }
        public string ProdType { get; set; }
        public string SerialNo { get; set; }
        public decimal Unitprice { get; set; }
        public decimal? PoPrice { get; set; }
        public decimal Cost { get; set; }
        public decimal TaxType { get; set; }
        public string CategoryCode { get; set; }
        public decimal? WideUseType { get; set; }
        public decimal? StockManageType { get; set; }
        public decimal? StockReserveType { get; set; }
        public string SupCode { get; set; }
        public decimal? SupSubNo { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public Bom Bom { get; set; }
        public ICollection<LocationMst> LocationMst { get; set; }
        public ICollection<PuDetails> PuDetails { get; set; }
    }
}
