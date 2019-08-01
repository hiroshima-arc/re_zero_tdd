﻿using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class AlternateProducts
    {
        public string ProdCode { get; set; }
        public string AltProdCode { get; set; }
        public decimal? Priority { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
    }
}
