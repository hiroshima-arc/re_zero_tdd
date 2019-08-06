using System;
using System.Collections.Generic;

namespace SalesManagement.Domain.Models.ManagementResources.Employee
{
    public sealed class Employee
    {
        public Employee()
        {
            Orders = new HashSet<Orders>();
            Pu = new HashSet<Pu>();
            PurchaseOrders = new HashSet<PurchaseOrders>();
        }

        public string EmpCode { get; set; }
        public string EmpName { get; set; }
        public string EmpKana { get; set; }
        public string LoginPassword { get; set; }
        public string Tel { get; set; }
        public string Fax { get; set; }
        public string DeptCode { get; set; }
        public DateTime? StartDate { get; set; }
        public string OccuCode { get; set; }
        public string ApprovalCode { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }

        public ICollection<Orders> Orders { get; set; }
        public ICollection<Pu> Pu { get; set; }
        public ICollection<PurchaseOrders> PurchaseOrders { get; set; }
    }
}
