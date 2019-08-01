using System;
using System.Collections.Generic;

namespace SalesManagement.Models
{
    public partial class Pricebycustomer
    {
        public string ProdCode { get; set; }
        public string CompCode { get; set; }
        public decimal Unitprice { get; set; }

        public virtual CompanysMst CompCodeNavigation { get; set; }
    }
}
