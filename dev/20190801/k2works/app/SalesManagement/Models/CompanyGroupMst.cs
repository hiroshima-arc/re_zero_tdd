using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class CompanyGroupMst
    {
        public string CompGroupCode { get; set; }
        public string GroupName { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
    }
}
