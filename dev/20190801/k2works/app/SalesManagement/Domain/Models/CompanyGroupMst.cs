using System;

namespace SalesManagement.Domain.Models
{
    public class CompanyGroupMst
    {
        public string CompGroupCode { get; set; }
        public string GroupName { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
    }
}
