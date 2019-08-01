using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class WhMst
    {
        public WhMst()
        {
            LocationMst = new HashSet<LocationMst>();
            Orders = new HashSet<Orders>();
            PuDetails = new HashSet<PuDetails>();
            Stock = new HashSet<Stock>();
            WhDeptMst = new HashSet<WhDeptMst>();
        }

        public string WhCode { get; set; }
        public string WhName { get; set; }
        public string WhType { get; set; }
        public string ZipCode { get; set; }
        public string State { get; set; }
        public string Address1 { get; set; }
        public string Address2 { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual ICollection<LocationMst> LocationMst { get; set; }
        public virtual ICollection<Orders> Orders { get; set; }
        public virtual ICollection<PuDetails> PuDetails { get; set; }
        public virtual ICollection<Stock> Stock { get; set; }
        public virtual ICollection<WhDeptMst> WhDeptMst { get; set; }
    }
}
