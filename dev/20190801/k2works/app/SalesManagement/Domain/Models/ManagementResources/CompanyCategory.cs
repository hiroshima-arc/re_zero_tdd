using System;
using System.Collections.Generic;

namespace SalesManagement.Domain.Models.ManagementResources
{
    public sealed class CompanyCategory
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

        public CategoryType CategoryTypeNavigation { get; set; }
        public ICollection<CompanyCategoryGroup> CompanyCategoryGroup { get; set; }
    }
}
