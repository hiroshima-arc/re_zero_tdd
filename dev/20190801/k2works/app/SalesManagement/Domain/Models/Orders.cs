using System;
using System.Collections.Generic;
using SalesManagement.Domain.Models.ManagementResources;
using SalesManagement.Domain.Models.ManagementResources.Employee;

namespace SalesManagement.Domain.Models
{
    public sealed class Orders
    {
        public Orders()
        {
            OrderDetails = new HashSet<OrderDetails>();
        }

        public string OrderNo { get; set; }
        public DateTime OrderDate { get; set; }
        public string DeptCode { get; set; }
        public string CustCode { get; set; }
        public decimal? CustSubNo { get; set; }
        public string EmpCode { get; set; }
        public DateTime? RequiredDate { get; set; }
        public string CustorderNo { get; set; }
        public string WhCode { get; set; }
        public decimal OrderAmnt { get; set; }
        public decimal CmpTax { get; set; }
        public string SlipComment { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public CustomersMst Cust { get; set; }
        public Employee EmpCodeNavigation { get; set; }
        public WhMst WhCodeNavigation { get; set; }
        public ICollection<OrderDetails> OrderDetails { get; set; }
    }
}
