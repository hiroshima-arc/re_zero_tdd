using System;
using System.Collections.Generic;
using SalesManagement.Domain.Models.ManagementResources.Employee;

namespace SalesManagement.Domain.Models
{
    public sealed class PurchaseOrders
    {
        public PurchaseOrders()
        {
            PoDetails = new HashSet<PoDetails>();
        }

        public string PoNo { get; set; }
        public DateTime? PoDate { get; set; }
        public string OrderNo { get; set; }
        public string SupCode { get; set; }
        public decimal? SupSubNo { get; set; }
        public string EmpCode { get; set; }
        public DateTime? DueDate { get; set; }
        public string WhCode { get; set; }
        public decimal? PoAmnt { get; set; }
        public decimal CmpTax { get; set; }
        public string SlipComment { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public Employee EmpCodeNavigation { get; set; }
        public ICollection<PoDetails> PoDetails { get; set; }
    }
}
