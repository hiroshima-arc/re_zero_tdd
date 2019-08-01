using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class CompanyCategoryGroup
    {
        public string CategoryType { get; set; }
        public string CompCateCode { get; set; }
        public string CompCode { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual CompanyCategory C { get; set; }
    }
}
