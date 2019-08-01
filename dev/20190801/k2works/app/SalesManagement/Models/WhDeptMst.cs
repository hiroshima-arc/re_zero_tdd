using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class WhDeptMst
    {
        public string WhCode { get; set; }
        public string DeptCode { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
        public DateTime StartDate { get; set; }

        public virtual DeptMst DeptMst { get; set; }
        public virtual WhMst WhCodeNavigation { get; set; }
    }
}
