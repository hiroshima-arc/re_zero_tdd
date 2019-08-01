using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class CreditBalance
    {
        public string CompCode { get; set; }
        public decimal? OrderBalance { get; set; }
        public decimal? RecBalance { get; set; }
        public decimal? PayBalance { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual CompanysMst CompCodeNavigation { get; set; }
    }
}
