﻿using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class CategoryType
    {
        public CategoryType()
        {
            CompanyCategory = new HashSet<CompanyCategory>();
        }

        public string CategoryTypeCode { get; set; }
        public string CateTypeName { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public virtual ICollection<CompanyCategory> CompanyCategory { get; set; }
    }
}
