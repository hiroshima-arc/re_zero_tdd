using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class LocationMst
    {
        public string WhCode { get; set; }
        public string LocationCode { get; set; }
        public string ProdCode { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual Products ProdCodeNavigation { get; set; }
        public virtual WhMst WhCodeNavigation { get; set; }
    }
}
