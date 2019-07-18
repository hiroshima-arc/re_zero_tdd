using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MvcMovie.Models
{
    public class Movie
    {
        public int Id { get; set; }
        [Display(Name = "タイトル")]
        public string Title { get; set; }

        [Display(Name = "公開日")]
        [DataType(DataType.Date)] public DateTime ReleaseDate { get; set; }
        [Display(Name = "ジャンル")]
        public string Genre { get; set; }
        [Display(Name = "値段")]
        [Column(TypeName = "decimal(18, 2)")]
        public decimal Price { get; set; }
        [Display(Name = "評価")]
        public string Rating { get; set; }
    }
}

