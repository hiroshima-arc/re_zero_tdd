using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class CompanyCategory
    {
        public CompanyCategory()
        {
            CompanyCategoryGroup = new HashSet<CompanyCategoryGroup>();
        }

        public string CategoryType { get; set; }
        public string CompCateCode { get; set; }
        public string CompCateName { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual CategoryType CategoryTypeNavigation { get; set; }
        public virtual ICollection<CompanyCategoryGroup> CompanyCategoryGroup { get; set; }
    }
}
