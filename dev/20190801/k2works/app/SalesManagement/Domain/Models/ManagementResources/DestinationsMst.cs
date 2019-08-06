using System;

namespace SalesManagement.Domain.Models.ManagementResources
{
    public class DestinationsMst
    {
        public string CompCode { get; set; }
        public decimal CompSubNo { get; set; }
        public decimal DistNo { get; set; }
        public string DistName { get; set; }
        public string ZipCode { get; set; }
        public string Address1 { get; set; }
        public string Address2 { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
    }
}
