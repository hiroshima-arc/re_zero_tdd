using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MvcMovie.Models
{
    public class Movie
    {
        public int Id { get; set; }

        [Display(Name = "タイトル")]
        [StringLength(60, MinimumLength = 3)]
        [Required(ErrorMessage = "未入力です")]
        public string Title { get; set; }

        [Display(Name = "公開日")]
        [DataType(DataType.Date)]
        [Required(ErrorMessage = "未入力です")]
        public DateTime ReleaseDate { get; set; }

        [Display(Name = "ジャンル")]
        [RegularExpression(@"^[A-Z]+[a-zA-Z""'\s-]+$")]
        [Required(ErrorMessage = "未入力です")]
        [StringLength(30)]
        public string Genre { get; set; }

        [Display(Name = "値段")]
        [Range(1, 100)]
        [DataType(DataType.Currency)]
        [Column(TypeName = "decimal(18, 2)")]
        [Required(ErrorMessage = "未入力です")]
        public decimal Price { get; set; }

        [Display(Name = "評価")]
        [RegularExpression(@"^[A-Z]+[a-zA-Z0-9""'\s-]*$")]
        [StringLength(5)]
        [Required(ErrorMessage = "未入力です")]
        public string Rating { get; set; }
    }
}