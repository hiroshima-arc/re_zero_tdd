using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Bom
    {
        public string ProdCode { get; set; }
        public string BomCode { get; set; }
        public decimal Quantity { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual Products ProdCodeNavigation { get; set; }
    }
}
