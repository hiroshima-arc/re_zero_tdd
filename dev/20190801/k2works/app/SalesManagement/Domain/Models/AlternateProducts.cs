using System;

namespace SalesManagement.Domain.Models
{
    public class AlternateProducts
    {
        public string ProdCode { get; set; }
        public string AltProdCode { get; set; }
        public decimal? Priority { get; set; }
        public DateTime UpdateDate { get; set; }
        public string Updater { get; set; }
    }
}
