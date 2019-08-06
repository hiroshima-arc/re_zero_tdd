using Microsoft.EntityFrameworkCore;
using SalesManagement.Domain.Models;
using SalesManagement.Domain.Models.ManagementResources;
using SalesManagement.Domain.Models.ManagementResources.Department;
using SalesManagement.Domain.Models.ManagementResources.Employee;
using SalesManagement.Domain.Models.ManagementResources.Product;

namespace SalesManagement.Infrastructure
{
    public class SalesContext : DbContext
    {
        public SalesContext()
        {
        }

        public SalesContext(DbContextOptions<SalesContext> options)
            : base(options)
        {
        }

        public virtual DbSet<AlternateProducts> AlternateProducts { get; set; }
        public virtual DbSet<AutoNumber> AutoNumber { get; set; }
        public virtual DbSet<BankAcutMst> BankAcutMst { get; set; }
        public virtual DbSet<Bom> Bom { get; set; }
        public virtual DbSet<CategoryType> CategoryType { get; set; }
        public virtual DbSet<CompanyCategory> CompanyCategory { get; set; }
        public virtual DbSet<CompanyCategoryGroup> CompanyCategoryGroup { get; set; }
        public virtual DbSet<CompanyGroupMst> CompanyGroupMst { get; set; }
        public virtual DbSet<CompanysMst> CompanysMst { get; set; }
        public virtual DbSet<Credit> Credit { get; set; }
        public virtual DbSet<CreditBalance> CreditBalance { get; set; }
        public virtual DbSet<CustomersMst> CustomersMst { get; set; }
        public virtual DbSet<DeptMst> DeptMst { get; set; }
        public virtual DbSet<DestinationsMst> DestinationsMst { get; set; }
        public virtual DbSet<Employee> Employee { get; set; }
        public virtual DbSet<Invoice> Invoice { get; set; }
        public virtual DbSet<InvoiceDetails> InvoiceDetails { get; set; }
        public virtual DbSet<LocationMst> LocationMst { get; set; }
        public virtual DbSet<OrderDetails> OrderDetails { get; set; }
        public virtual DbSet<Orders> Orders { get; set; }
        public virtual DbSet<Pay> Pay { get; set; }
        public virtual DbSet<PoDetails> PoDetails { get; set; }
        public virtual DbSet<Pricebycustomer> Pricebycustomer { get; set; }
        public virtual DbSet<ProductCategory> ProductCategory { get; set; }
        public virtual DbSet<Products> Products { get; set; }
        public virtual DbSet<Pu> Pu { get; set; }
        public virtual DbSet<PuDetails> PuDetails { get; set; }
        public virtual DbSet<PurchaseOrders> PurchaseOrders { get; set; }
        public virtual DbSet<Sales> Sales { get; set; }
        public virtual DbSet<SalesDetails> SalesDetails { get; set; }
        public virtual DbSet<Stock> Stock { get; set; }
        public virtual DbSet<SupplierMst> SupplierMst { get; set; }
        public virtual DbSet<WhDeptMst> WhDeptMst { get; set; }
        public virtual DbSet<WhMst> WhMst { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Server=localhost;Initial Catalog=Sales;Integrated Security=True");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasAnnotation("ProductVersion", "2.2.6-servicing-10079");

            modelBuilder.Entity<AlternateProducts>(entity =>
            {
                entity.HasKey(e => new { e.ProdCode, e.AltProdCode })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("ALTERNATE_PRODUCTS");

                entity.Property(e => e.ProdCode)
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.AltProdCode)
                    .HasColumnName("ALT_PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.Priority)
                    .HasColumnName("PRIORITY")
                    .HasColumnType("numeric(2, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<AutoNumber>(entity =>
            {
                entity.HasKey(e => new { e.SlipType, e.Yearmonth })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("AUTO_NUMBER");

                entity.Property(e => e.SlipType)
                    .HasColumnName("SLIP_TYPE")
                    .HasMaxLength(2);

                entity.Property(e => e.Yearmonth)
                    .HasColumnName("YEARMONTH")
                    .HasColumnType("datetime");

                entity.Property(e => e.LastSilpNo)
                    .HasColumnName("LAST_SILP_NO")
                    .HasColumnType("numeric(4, 0)");
            });

            modelBuilder.Entity<BankAcutMst>(entity =>
            {
                entity.HasKey(e => e.BankAcutCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("BANK_ACUT_MST");

                entity.Property(e => e.BankAcutCode)
                    .HasColumnName("BANK_ACUT_CODE")
                    .HasMaxLength(8)
                    .ValueGeneratedNever();

                entity.Property(e => e.ABankBlncCode)
                    .HasColumnName("A_BANK_BLNC_CODE")
                    .HasMaxLength(3);

                entity.Property(e => e.ABankCode)
                    .HasColumnName("A_BANK_CODE")
                    .HasMaxLength(4);

                entity.Property(e => e.ActName)
                    .HasColumnName("ACT_NAME")
                    .HasMaxLength(20);

                entity.Property(e => e.ApplEndDate)
                    .HasColumnName("APPL_END_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("('2100/12/31')");

                entity.Property(e => e.ApplStartDate)
                    .HasColumnName("APPL_START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.BankActType)
                    .HasColumnName("BANK_ACT_TYPE")
                    .HasMaxLength(1);

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.ReciveActName)
                    .HasColumnName("RECIVE_ACT_NAME")
                    .HasMaxLength(30);

                entity.Property(e => e.ReciveActNo)
                    .HasColumnName("RECIVE_ACT_NO")
                    .HasMaxLength(12);

                entity.Property(e => e.ReciveBankActType)
                    .HasColumnName("RECIVE_BANK_ACT_TYPE")
                    .HasMaxLength(1);

                entity.Property(e => e.StartActName)
                    .HasColumnName("START_ACT_NAME")
                    .HasMaxLength(30);

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdatePgm)
                    .HasColumnName("UPDATE_PGM")
                    .HasMaxLength(50);

                entity.Property(e => e.UpdatePlgDate)
                    .HasColumnName("UPDATE_PLG_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.DeptMst)
                    .WithMany(p => p.BankAcutMst)
                    .HasForeignKey(d => new { d.DeptCode, d.StartDate })
                    .HasConstraintName("FK_DEPT_MST_BANK_ACUT_MST");
            });

            modelBuilder.Entity<Bom>(entity =>
            {
                entity.HasKey(e => e.ProdCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("BOM");

                entity.Property(e => e.ProdCode)
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16)
                    .ValueGeneratedNever();

                entity.Property(e => e.BomCode)
                    .IsRequired()
                    .HasColumnName("BOM_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.Quantity)
                    .HasColumnName("QUANTITY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.ProdCodeNavigation)
                    .WithOne(p => p.Bom)
                    .HasForeignKey<Bom>(d => d.ProdCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_PRODUCTS_BOM");
            });

            modelBuilder.Entity<CategoryType>(entity =>
            {
                entity.HasKey(e => e.CategoryTypeCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("CATEGORY_TYPE");

                entity.Property(e => e.CategoryTypeCode)
                    .HasColumnName("CATEGORY_TYPE_CODE")
                    .HasMaxLength(2)
                    .ValueGeneratedNever();

                entity.Property(e => e.CateTypeName)
                    .HasColumnName("CATE_TYPE_NAME")
                    .HasMaxLength(20);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<CompanyCategory>(entity =>
            {
                entity.HasKey(e => new { e.CompCateCode, e.CategoryType })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("COMPANY_CATEGORY");

                entity.Property(e => e.CompCateCode)
                    .HasColumnName("COMP_CATE_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CategoryType)
                    .HasColumnName("CATEGORY_TYPE")
                    .HasMaxLength(2);

                entity.Property(e => e.CompCateName)
                    .HasColumnName("COMP_CATE_NAME")
                    .HasMaxLength(30);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.CategoryTypeNavigation)
                    .WithMany(p => p.CompanyCategory)
                    .HasForeignKey(d => d.CategoryType)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_CATEGORY_TYPE_COMPANY_CATEG");
            });

            modelBuilder.Entity<CompanyCategoryGroup>(entity =>
            {
                entity.HasKey(e => new { e.CategoryType, e.CompCode, e.CompCateCode })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("COMPANY_CATEGORY_GROUP");

                entity.Property(e => e.CategoryType)
                    .HasColumnName("CATEGORY_TYPE")
                    .HasMaxLength(2);

                entity.Property(e => e.CompCode)
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CompCateCode)
                    .HasColumnName("COMP_CATE_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.C)
                    .WithMany(p => p.CompanyCategoryGroup)
                    .HasForeignKey(d => new { d.CompCateCode, d.CategoryType })
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_COMPANY_CATEGORY_COMPANY_CA");
            });

            modelBuilder.Entity<CompanyGroupMst>(entity =>
            {
                entity.HasKey(e => e.CompGroupCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("COMPANY_GROUP_MST");

                entity.Property(e => e.CompGroupCode)
                    .HasColumnName("COMP_GROUP_CODE")
                    .HasMaxLength(4)
                    .ValueGeneratedNever();

                entity.Property(e => e.GroupName)
                    .HasColumnName("GROUP_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<CompanysMst>(entity =>
            {
                entity.HasKey(e => e.CompCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("COMPANYS_MST");

                entity.Property(e => e.CompCode)
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8)
                    .ValueGeneratedNever();

                entity.Property(e => e.Address1)
                    .HasColumnName("ADDRESS1")
                    .HasMaxLength(40);

                entity.Property(e => e.Address2)
                    .HasColumnName("ADDRESS2")
                    .HasMaxLength(40);

                entity.Property(e => e.CompGroupCode)
                    .IsRequired()
                    .HasColumnName("COMP_GROUP_CODE")
                    .HasMaxLength(4);

                entity.Property(e => e.CompKana)
                    .HasColumnName("COMP_KANA")
                    .HasMaxLength(40);

                entity.Property(e => e.CompName)
                    .IsRequired()
                    .HasColumnName("COMP_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.MaxCredit)
                    .HasColumnName("MAX_CREDIT")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.NoSalesFlg)
                    .HasColumnName("NO_SALES_FLG")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.State)
                    .HasColumnName("STATE")
                    .HasMaxLength(4);

                entity.Property(e => e.SupType)
                    .HasColumnName("SUP_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.TempCreditUp)
                    .HasColumnName("TEMP_CREDIT_UP")
                    .HasColumnType("numeric(10, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.WideUseType)
                    .HasColumnName("WIDE_USE_TYPE")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.ZipCode)
                    .HasColumnName("ZIP_CODE")
                    .HasMaxLength(8);
            });

            modelBuilder.Entity<Credit>(entity =>
            {
                entity.HasKey(e => e.CreditNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("CREDIT");

                entity.Property(e => e.CreditNo)
                    .HasColumnName("CREDIT_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.BankAcutCode)
                    .HasColumnName("BANK_ACUT_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CompCode)
                    .IsRequired()
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CompSubNo)
                    .HasColumnName("COMP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.CreditDate)
                    .HasColumnName("CREDIT_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.PayMethodType)
                    .HasColumnName("PAY_METHOD_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.Received)
                    .HasColumnName("RECEIVED")
                    .HasColumnType("numeric(13, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.ReceivedAmnt)
                    .HasColumnName("RECEIVED_AMNT")
                    .HasColumnType("numeric(13, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdatePgm)
                    .HasColumnName("UPDATE_PGM")
                    .HasMaxLength(50);

                entity.Property(e => e.UpdatePlgDate)
                    .HasColumnName("UPDATE_PLG_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.DeptMst)
                    .WithMany(p => p.Credit)
                    .HasForeignKey(d => new { d.DeptCode, d.StartDate })
                    .HasConstraintName("FK_DEPT_MST_CREDIT");
            });

            modelBuilder.Entity<CreditBalance>(entity =>
            {
                entity.HasKey(e => e.CompCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("CREDIT_BALANCE");

                entity.Property(e => e.CompCode)
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8)
                    .ValueGeneratedNever();

                entity.Property(e => e.OrderBalance)
                    .HasColumnName("ORDER_BALANCE")
                    .HasColumnType("numeric(13, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.PayBalance)
                    .HasColumnName("PAY_BALANCE")
                    .HasColumnType("numeric(13, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.RecBalance)
                    .HasColumnName("REC_BALANCE")
                    .HasColumnType("numeric(13, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.CompCodeNavigation)
                    .WithOne(p => p.CreditBalance)
                    .HasForeignKey<CreditBalance>(d => d.CompCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_COMPANYS_MST_CREDIT_BALANC");
            });

            modelBuilder.Entity<CustomersMst>(entity =>
            {
                entity.HasKey(e => new { e.CustCode, e.CustSubNo })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("CUSTOMERS_MST");

                entity.Property(e => e.CustCode)
                    .HasColumnName("CUST_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CustSubNo)
                    .HasColumnName("CUST_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.ArCode)
                    .IsRequired()
                    .HasColumnName("AR_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.ArSubNo)
                    .HasColumnName("AR_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.CustAddress1)
                    .HasColumnName("CUST_ADDRESS1")
                    .HasMaxLength(40);

                entity.Property(e => e.CustAddress2)
                    .HasColumnName("CUST_ADDRESS2")
                    .HasMaxLength(40);

                entity.Property(e => e.CustArFlag)
                    .HasColumnName("CUST_AR_FLAG")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.CustCloseDate1)
                    .HasColumnName("CUST_CLOSE_DATE1")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.CustCloseDate2)
                    .HasColumnName("CUST_CLOSE_DATE2")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.CustEmail)
                    .HasColumnName("CUST_EMAIL")
                    .HasMaxLength(100);

                entity.Property(e => e.CustFax)
                    .HasColumnName("CUST_FAX")
                    .HasMaxLength(13);

                entity.Property(e => e.CustKana)
                    .HasColumnName("CUST_KANA")
                    .HasMaxLength(40);

                entity.Property(e => e.CustName)
                    .IsRequired()
                    .HasColumnName("CUST_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.CustPayDates1)
                    .HasColumnName("CUST_PAY_DATES1")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.CustPayDates2)
                    .HasColumnName("CUST_PAY_DATES2")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.CustPayMethod1)
                    .HasColumnName("CUST_PAY_METHOD1")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.CustPayMethod2)
                    .HasColumnName("CUST_PAY_METHOD2")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.CustPayMonths1)
                    .HasColumnName("CUST_PAY_MONTHS1")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.CustPayMonths2)
                    .HasColumnName("CUST_PAY_MONTHS2")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.CustState)
                    .HasColumnName("CUST_STATE")
                    .HasMaxLength(4);

                entity.Property(e => e.CustTel)
                    .HasColumnName("CUST_TEL")
                    .HasMaxLength(13);

                entity.Property(e => e.CustType)
                    .HasColumnName("CUST_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.CustUserDepName)
                    .HasColumnName("CUST_USER_DEP_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.CustUserName)
                    .HasColumnName("CUST_USER_NAME")
                    .HasMaxLength(20);

                entity.Property(e => e.CustZipCode)
                    .HasColumnName("CUST_ZIP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.EmpCode)
                    .IsRequired()
                    .HasColumnName("EMP_CODE")
                    .HasMaxLength(10);

                entity.Property(e => e.PayerCode)
                    .IsRequired()
                    .HasColumnName("PAYER_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.PayerSubNo)
                    .HasColumnName("PAYER_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.CustCodeNavigation)
                    .WithMany(p => p.CustomersMst)
                    .HasForeignKey(d => d.CustCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_COMPANYS_MST_CUSTOMERS_MST");
            });

            modelBuilder.Entity<DeptMst>(entity =>
            {
                entity.HasKey(e => new { e.DeptCode, e.StartDate })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("DEPT_MST");

                entity.Property(e => e.DeptCode)
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.DepName)
                    .HasColumnName("DEP_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.EndDate)
                    .HasColumnName("END_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("('2100/12/31')");

                entity.Property(e => e.Layer)
                    .HasColumnName("LAYER")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.SlitYn)
                    .HasColumnName("SLIT_YN")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.UpDivisionCode)
                    .IsRequired()
                    .HasColumnName("UP_DIVISION_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<DestinationsMst>(entity =>
            {
                entity.HasKey(e => new { e.CompCode, e.DistNo, e.CompSubNo })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("DESTINATIONS_MST");

                entity.Property(e => e.CompCode)
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.DistNo)
                    .HasColumnName("DIST_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.CompSubNo)
                    .HasColumnName("COMP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.Address1)
                    .HasColumnName("ADDRESS1")
                    .HasMaxLength(40);

                entity.Property(e => e.Address2)
                    .HasColumnName("ADDRESS2")
                    .HasMaxLength(40);

                entity.Property(e => e.DistName)
                    .IsRequired()
                    .HasColumnName("DIST_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.ZipCode)
                    .HasColumnName("ZIP_CODE")
                    .HasMaxLength(8);
            });

            modelBuilder.Entity<Employee>(entity =>
            {
                entity.HasKey(e => e.EmpCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("EMPLOYEE");

                entity.Property(e => e.EmpCode)
                    .HasColumnName("EMP_CODE")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.ApprovalCode)
                    .IsRequired()
                    .HasColumnName("APPROVAL_CODE")
                    .HasMaxLength(2);

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.EmpKana)
                    .HasColumnName("EMP_KANA")
                    .HasMaxLength(40);

                entity.Property(e => e.EmpName)
                    .HasColumnName("EMP_NAME")
                    .HasMaxLength(20);

                entity.Property(e => e.Fax)
                    .HasColumnName("FAX")
                    .HasMaxLength(13);

                entity.Property(e => e.LoginPassword)
                    .HasColumnName("LOGIN_PASSWORD")
                    .HasMaxLength(8);

                entity.Property(e => e.OccuCode)
                    .IsRequired()
                    .HasColumnName("OCCU_CODE")
                    .HasMaxLength(2);

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Tel)
                    .HasColumnName("TEL")
                    .HasMaxLength(13);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<Invoice>(entity =>
            {
                entity.HasKey(e => e.InvoiceNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("INVOICE");

                entity.Property(e => e.InvoiceNo)
                    .HasColumnName("INVOICE_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.CmpTax)
                    .HasColumnName("CMP_TAX")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.CompCode)
                    .IsRequired()
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CustSubNo)
                    .HasColumnName("CUST_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.InvoiceReceived)
                    .HasColumnName("INVOICE_RECEIVED")
                    .HasColumnType("numeric(13, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.InvoicedDate)
                    .HasColumnName("INVOICED_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.LastReceived)
                    .HasColumnName("LAST_RECEIVED")
                    .HasColumnType("numeric(13, 0)");

                entity.Property(e => e.MonthInvoice)
                    .HasColumnName("MONTH_INVOICE")
                    .HasColumnType("numeric(13, 0)");

                entity.Property(e => e.MonthReceived)
                    .HasColumnName("MONTH_RECEIVED")
                    .HasColumnType("numeric(13, 0)");

                entity.Property(e => e.MonthSales)
                    .HasColumnName("MONTH_SALES")
                    .HasColumnType("numeric(13, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<InvoiceDetails>(entity =>
            {
                entity.HasKey(e => new { e.InvoiceNo, e.SalesNo, e.RowNo })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("INVOICE_DETAILS");

                entity.Property(e => e.InvoiceNo)
                    .HasColumnName("INVOICE_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.SalesNo)
                    .HasColumnName("SALES_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.RowNo)
                    .HasColumnName("ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.InvoiceNoNavigation)
                    .WithMany(p => p.InvoiceDetails)
                    .HasForeignKey(d => d.InvoiceNo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_INVOICE_INVOICE_DETAILS");
            });

            modelBuilder.Entity<LocationMst>(entity =>
            {
                entity.HasKey(e => new { e.WhCode, e.LocationCode, e.ProdCode })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("LOCATION_MST");

                entity.Property(e => e.WhCode)
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3);

                entity.Property(e => e.LocationCode)
                    .HasColumnName("LOCATION_CODE")
                    .HasMaxLength(4);

                entity.Property(e => e.ProdCode)
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.ProdCodeNavigation)
                    .WithMany(p => p.LocationMst)
                    .HasForeignKey(d => d.ProdCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_PRODUCTS_LOCATION_MST");

                entity.HasOne(d => d.WhCodeNavigation)
                    .WithMany(p => p.LocationMst)
                    .HasForeignKey(d => d.WhCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_WH_MST_LOCATION_MST");
            });

            modelBuilder.Entity<OrderDetails>(entity =>
            {
                entity.HasKey(e => new { e.OrderNo, e.SoRowNo })
                    .HasName("ORDER_DETAILS_PKEY")
                    .ForSqlServerIsClustered(false);

                entity.ToTable("ORDER_DETAILS");

                entity.Property(e => e.OrderNo)
                    .HasColumnName("ORDER_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.SoRowNo)
                    .HasColumnName("SO_ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.CmpTaxRate)
                    .HasColumnName("CMP_TAX_RATE")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.CompleteFlg)
                    .HasColumnName("COMPLETE_FLG")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.DeliveredQty)
                    .HasColumnName("DELIVERED_QTY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.DeliveryDate)
                    .HasColumnName("DELIVERY_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.DeliveryOrderQty)
                    .HasColumnName("DELIVERY_ORDER_QTY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.Discount)
                    .HasColumnName("DISCOUNT")
                    .HasColumnType("numeric(4, 0)");

                entity.Property(e => e.ProdCode)
                    .IsRequired()
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.ProdName)
                    .IsRequired()
                    .HasColumnName("PROD_NAME")
                    .HasMaxLength(10);

                entity.Property(e => e.Quantity)
                    .HasColumnName("QUANTITY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.ReserveQty)
                    .HasColumnName("RESERVE_QTY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.Unitprice)
                    .HasColumnName("UNITPRICE")
                    .HasColumnType("numeric(8, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.OrderNoNavigation)
                    .WithMany(p => p.OrderDetails)
                    .HasForeignKey(d => d.OrderNo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_ORDERS_ORDER_DETAILS");
            });

            modelBuilder.Entity<Orders>(entity =>
            {
                entity.HasKey(e => e.OrderNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("ORDERS");

                entity.Property(e => e.OrderNo)
                    .HasColumnName("ORDER_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.CmpTax)
                    .HasColumnName("CMP_TAX")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.CustCode)
                    .IsRequired()
                    .HasColumnName("CUST_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.CustSubNo)
                    .HasColumnName("CUST_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.CustorderNo)
                    .HasColumnName("CUSTORDER_NO")
                    .HasMaxLength(20);

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.EmpCode)
                    .IsRequired()
                    .HasColumnName("EMP_CODE")
                    .HasMaxLength(10);

                entity.Property(e => e.OrderAmnt)
                    .HasColumnName("ORDER_AMNT")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.OrderDate)
                    .HasColumnName("ORDER_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.RequiredDate)
                    .HasColumnName("REQUIRED_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.SlipComment)
                    .HasColumnName("SLIP_COMMENT")
                    .HasMaxLength(1000);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.WhCode)
                    .IsRequired()
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3);

                entity.HasOne(d => d.EmpCodeNavigation)
                    .WithMany(p => p.Orders)
                    .HasForeignKey(d => d.EmpCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_EMPLOYEE_ORDERS");

                entity.HasOne(d => d.WhCodeNavigation)
                    .WithMany(p => p.Orders)
                    .HasForeignKey(d => d.WhCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_WH_MST_ORDERS");

                entity.HasOne(d => d.Cust)
                    .WithMany(p => p.Orders)
                    .HasForeignKey(d => new { d.CustCode, d.CustSubNo })
                    .HasConstraintName("FK_CUSTOMERS_MST_ORDERS");
            });

            modelBuilder.Entity<Pay>(entity =>
            {
                entity.HasKey(e => e.PayNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PAY");

                entity.Property(e => e.PayNo)
                    .HasColumnName("PAY_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.CmpTax)
                    .HasColumnName("CMP_TAX")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.CompleteFlg)
                    .HasColumnName("COMPLETE_FLG")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.PayAmnt)
                    .HasColumnName("PAY_AMNT")
                    .HasColumnType("numeric(13, 0)");

                entity.Property(e => e.PayDate)
                    .HasColumnName("PAY_DATE")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.PayMethodType)
                    .HasColumnName("PAY_METHOD_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.SupCode)
                    .IsRequired()
                    .HasColumnName("SUP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.SupSubNo)
                    .HasColumnName("SUP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.DeptMst)
                    .WithMany(p => p.Pay)
                    .HasForeignKey(d => new { d.DeptCode, d.StartDate })
                    .HasConstraintName("FK_DEPT_MST_PAY");

                entity.HasOne(d => d.Sup)
                    .WithMany(p => p.Pay)
                    .HasForeignKey(d => new { d.SupCode, d.SupSubNo })
                    .HasConstraintName("FK_SUPPLIER_MST_PAY");
            });

            modelBuilder.Entity<PoDetails>(entity =>
            {
                entity.HasKey(e => new { e.PoRowNo, e.PoNo })
                    .HasName("PO_DETAILS_PKEY")
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PO_DETAILS");

                entity.Property(e => e.PoRowNo)
                    .HasColumnName("PO_ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.PoNo)
                    .HasColumnName("PO_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.CompleteFlg)
                    .HasColumnName("COMPLETE_FLG")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.OrderNo)
                    .IsRequired()
                    .HasColumnName("ORDER_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.PoPrice)
                    .HasColumnName("PO_PRICE")
                    .HasColumnType("numeric(8, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.PoQt)
                    .HasColumnName("PO_QT")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.PoRowDspNo)
                    .HasColumnName("PO_ROW_DSP_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.ProdCode)
                    .IsRequired()
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.ProdName)
                    .IsRequired()
                    .HasColumnName("PROD_NAME")
                    .HasMaxLength(10);

                entity.Property(e => e.RecivedQt)
                    .HasColumnName("RECIVED_QT")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.SoRowNo)
                    .HasColumnName("SO_ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.PoNoNavigation)
                    .WithMany(p => p.PoDetails)
                    .HasForeignKey(d => d.PoNo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_PURCHASE_ORDERS_PO_DETAILS");
            });

            modelBuilder.Entity<Pricebycustomer>(entity =>
            {
                entity.HasKey(e => new { e.ProdCode, e.CompCode })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PRICEBYCUSTOMER");

                entity.Property(e => e.ProdCode)
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.CompCode)
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.Unitprice)
                    .HasColumnName("UNITPRICE")
                    .HasColumnType("numeric(8, 0)");

                entity.HasOne(d => d.CompCodeNavigation)
                    .WithMany(p => p.Pricebycustomer)
                    .HasForeignKey(d => d.CompCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_COMPANYS_MST_PRICEBYCUSTOME");
            });

            modelBuilder.Entity<ProductCategory>(entity =>
            {
                entity.HasKey(e => e.CategoryCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PRODUCT_CATEGORY");

                entity.Property(e => e.CategoryCode)
                    .HasColumnName("CATEGORY_CODE")
                    .HasMaxLength(8)
                    .ValueGeneratedNever();

                entity.Property(e => e.Layer)
                    .HasColumnName("LAYER")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.ProdCateName)
                    .HasColumnName("PROD_CATE_NAME")
                    .HasMaxLength(30);
            });

            modelBuilder.Entity<Products>(entity =>
            {
                entity.HasKey(e => e.ProdCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PRODUCTS");

                entity.Property(e => e.ProdCode)
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16)
                    .ValueGeneratedNever();

                entity.Property(e => e.CategoryCode)
                    .HasColumnName("CATEGORY_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.Cost)
                    .HasColumnName("COST")
                    .HasColumnType("numeric(8, 0)");

                entity.Property(e => e.PoPrice)
                    .HasColumnName("PO_PRICE")
                    .HasColumnType("numeric(8, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.ProdFullname)
                    .IsRequired()
                    .HasColumnName("PROD_FULLNAME")
                    .HasMaxLength(40);

                entity.Property(e => e.ProdKana)
                    .IsRequired()
                    .HasColumnName("PROD_KANA")
                    .HasMaxLength(20);

                entity.Property(e => e.ProdName)
                    .IsRequired()
                    .HasColumnName("PROD_NAME")
                    .HasMaxLength(10);

                entity.Property(e => e.ProdType)
                    .HasColumnName("PROD_TYPE")
                    .HasMaxLength(1);

                entity.Property(e => e.SerialNo)
                    .HasColumnName("SERIAL_NO")
                    .HasMaxLength(40);

                entity.Property(e => e.StockManageType)
                    .HasColumnName("STOCK_MANAGE_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.StockReserveType)
                    .HasColumnName("STOCK_RESERVE_TYPE")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.SupCode)
                    .IsRequired()
                    .HasColumnName("SUP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.SupSubNo)
                    .HasColumnName("SUP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.TaxType)
                    .HasColumnName("TAX_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.Unitprice)
                    .HasColumnName("UNITPRICE")
                    .HasColumnType("numeric(8, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.WideUseType)
                    .HasColumnName("WIDE_USE_TYPE")
                    .HasColumnType("numeric(1, 0)");
            });

            modelBuilder.Entity<Pu>(entity =>
            {
                entity.HasKey(e => e.PuNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PU");

                entity.Property(e => e.PuNo)
                    .HasColumnName("PU_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.CmpTax)
                    .HasColumnName("CMP_TAX")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.EmpCode)
                    .IsRequired()
                    .HasColumnName("EMP_CODE")
                    .HasMaxLength(10);

                entity.Property(e => e.PoNo)
                    .HasColumnName("PO_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.PuAmmount)
                    .HasColumnName("PU_AMMOUNT")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.PuDate)
                    .HasColumnName("PU_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.SlipComment)
                    .HasColumnName("SLIP_COMMENT")
                    .HasMaxLength(1000);

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.SupCode)
                    .IsRequired()
                    .HasColumnName("SUP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.SupSubNo)
                    .HasColumnName("SUP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.EmpCodeNavigation)
                    .WithMany(p => p.Pu)
                    .HasForeignKey(d => d.EmpCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_EMPLOYEE_PU");

                entity.HasOne(d => d.DeptMst)
                    .WithMany(p => p.Pu)
                    .HasForeignKey(d => new { d.DeptCode, d.StartDate })
                    .HasConstraintName("FK_DEPT_MST_PU");
            });

            modelBuilder.Entity<PuDetails>(entity =>
            {
                entity.HasKey(e => new { e.PuRowNo, e.PuNo })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PU_DETAILS");

                entity.Property(e => e.PuRowNo)
                    .HasColumnName("PU_ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.PuNo)
                    .HasColumnName("PU_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.PoPrice)
                    .HasColumnName("PO_PRICE")
                    .HasColumnType("numeric(8, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.PoRowNo)
                    .HasColumnName("PO_ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.ProdCode)
                    .IsRequired()
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.ProdName)
                    .IsRequired()
                    .HasColumnName("PROD_NAME")
                    .HasMaxLength(10);

                entity.Property(e => e.PuQuantity)
                    .HasColumnName("PU_QUANTITY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.PuRowDspNo)
                    .HasColumnName("PU_ROW_DSP_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.WhCode)
                    .IsRequired()
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3);

                entity.HasOne(d => d.ProdCodeNavigation)
                    .WithMany(p => p.PuDetails)
                    .HasForeignKey(d => d.ProdCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_PRODUCTS_PU_DETAILS");

                entity.HasOne(d => d.PuNoNavigation)
                    .WithMany(p => p.PuDetails)
                    .HasForeignKey(d => d.PuNo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_PU_PU_DETAILS");

                entity.HasOne(d => d.WhCodeNavigation)
                    .WithMany(p => p.PuDetails)
                    .HasForeignKey(d => d.WhCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_WH_MST_PU_DETAILS");
            });

            modelBuilder.Entity<PurchaseOrders>(entity =>
            {
                entity.HasKey(e => e.PoNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("PURCHASE_ORDERS");

                entity.Property(e => e.PoNo)
                    .HasColumnName("PO_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.CmpTax)
                    .HasColumnName("CMP_TAX")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.DueDate)
                    .HasColumnName("DUE_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.EmpCode)
                    .IsRequired()
                    .HasColumnName("EMP_CODE")
                    .HasMaxLength(10);

                entity.Property(e => e.OrderNo)
                    .IsRequired()
                    .HasColumnName("ORDER_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.PoAmnt)
                    .HasColumnName("PO_AMNT")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.PoDate)
                    .HasColumnName("PO_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.SlipComment)
                    .HasColumnName("SLIP_COMMENT")
                    .HasMaxLength(1000);

                entity.Property(e => e.SupCode)
                    .IsRequired()
                    .HasColumnName("SUP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.SupSubNo)
                    .HasColumnName("SUP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.WhCode)
                    .IsRequired()
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3);

                entity.HasOne(d => d.EmpCodeNavigation)
                    .WithMany(p => p.PurchaseOrders)
                    .HasForeignKey(d => d.EmpCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_EMPLOYEE_PURCHASE_ORDERS");
            });

            modelBuilder.Entity<Sales>(entity =>
            {
                entity.HasKey(e => e.SalesNo)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("SALES");

                entity.Property(e => e.SalesNo)
                    .HasColumnName("SALES_NO")
                    .HasMaxLength(10)
                    .ValueGeneratedNever();

                entity.Property(e => e.CmpTax)
                    .HasColumnName("CMP_TAX")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.CompCode)
                    .IsRequired()
                    .HasColumnName("COMP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.DeptCode)
                    .IsRequired()
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.EmpCode)
                    .IsRequired()
                    .HasColumnName("EMP_CODE")
                    .HasMaxLength(10);

                entity.Property(e => e.OrderNo)
                    .IsRequired()
                    .HasColumnName("ORDER_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.OrgnlNo)
                    .HasColumnName("ORGNL_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.SalesAmnt)
                    .HasColumnName("SALES_AMNT")
                    .HasColumnType("numeric(13, 0)");

                entity.Property(e => e.SalesDate)
                    .HasColumnName("SALES_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.SalesType)
                    .HasColumnName("SALES_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.SlipComment)
                    .HasColumnName("SLIP_COMMENT")
                    .HasMaxLength(1000);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdatedNo)
                    .HasColumnName("UPDATED_NO")
                    .HasColumnType("numeric(10, 0)");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);
            });

            modelBuilder.Entity<SalesDetails>(entity =>
            {
                entity.HasKey(e => new { e.SalesNo, e.RowNo })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("SALES_DETAILS");

                entity.Property(e => e.SalesNo)
                    .HasColumnName("SALES_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.RowNo)
                    .HasColumnName("ROW_NO")
                    .HasColumnType("numeric(3, 0)");

                entity.Property(e => e.AutoJournalDate)
                    .HasColumnName("AUTO_JOURNAL_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.DeliveredQty)
                    .HasColumnName("DELIVERED_QTY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((0))");

                entity.Property(e => e.Discount)
                    .HasColumnName("DISCOUNT")
                    .HasColumnType("numeric(4, 0)");

                entity.Property(e => e.InvoiceDelayType)
                    .HasColumnName("INVOICE_DELAY_TYPE")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.InvoiceNo)
                    .HasColumnName("INVOICE_NO")
                    .HasMaxLength(10);

                entity.Property(e => e.InvoicedDate)
                    .HasColumnName("INVOICED_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.ProdCode)
                    .IsRequired()
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.ProdName)
                    .IsRequired()
                    .HasColumnName("PROD_NAME")
                    .HasMaxLength(10);

                entity.Property(e => e.Quantity)
                    .HasColumnName("QUANTITY")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.Unitprice)
                    .HasColumnName("UNITPRICE")
                    .HasColumnType("numeric(8, 0)");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.SalesNoNavigation)
                    .WithMany(p => p.SalesDetails)
                    .HasForeignKey(d => d.SalesNo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_SALES_SALES_DETAILS");
            });

            modelBuilder.Entity<Stock>(entity =>
            {
                entity.HasKey(e => new { e.WhCode, e.ProdCode, e.RotNo, e.StockType, e.QualityType })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("STOCK");

                entity.Property(e => e.WhCode)
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3);

                entity.Property(e => e.ProdCode)
                    .HasColumnName("PROD_CODE")
                    .HasMaxLength(16);

                entity.Property(e => e.RotNo)
                    .HasColumnName("ROT_NO")
                    .HasMaxLength(20);

                entity.Property(e => e.StockType)
                    .HasColumnName("STOCK_TYPE")
                    .HasMaxLength(1)
                    .HasDefaultValueSql("('1')");

                entity.Property(e => e.QualityType)
                    .HasColumnName("QUALITY_TYPE")
                    .HasMaxLength(1)
                    .HasDefaultValueSql("('G')");

                entity.Property(e => e.Actual)
                    .HasColumnName("ACTUAL")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.LastDeliveryDate)
                    .HasColumnName("LAST_DELIVERY_DATE")
                    .HasColumnType("datetime");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.Valid)
                    .HasColumnName("VALID")
                    .HasColumnType("numeric(4, 0)")
                    .HasDefaultValueSql("((1))");

                entity.HasOne(d => d.WhCodeNavigation)
                    .WithMany(p => p.Stock)
                    .HasForeignKey(d => d.WhCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_WH_MST_STOCK");
            });

            modelBuilder.Entity<SupplierMst>(entity =>
            {
                entity.HasKey(e => new { e.SupCode, e.SupSubNo })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("SUPPLIER_MST");

                entity.Property(e => e.SupCode)
                    .HasColumnName("SUP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.SupSubNo)
                    .HasColumnName("SUP_SUB_NO")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.PayMethodType)
                    .HasColumnName("PAY_METHOD_TYPE")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.SupAddress1)
                    .HasColumnName("SUP_ADDRESS1")
                    .HasMaxLength(40);

                entity.Property(e => e.SupAddress2)
                    .HasColumnName("SUP_ADDRESS2")
                    .HasMaxLength(40);

                entity.Property(e => e.SupCloseDate)
                    .HasColumnName("SUP_CLOSE_DATE")
                    .HasColumnType("numeric(2, 0)");

                entity.Property(e => e.SupDepName)
                    .HasColumnName("SUP_DEP_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.SupEmail)
                    .HasColumnName("SUP_EMAIL")
                    .HasMaxLength(100);

                entity.Property(e => e.SupEmpName)
                    .HasColumnName("SUP_EMP_NAME")
                    .HasMaxLength(20);

                entity.Property(e => e.SupFax)
                    .HasColumnName("SUP_FAX")
                    .HasMaxLength(13);

                entity.Property(e => e.SupKana)
                    .HasColumnName("SUP_KANA")
                    .HasMaxLength(40);

                entity.Property(e => e.SupName)
                    .IsRequired()
                    .HasColumnName("SUP_NAME")
                    .HasMaxLength(40);

                entity.Property(e => e.SupPayDates)
                    .HasColumnName("SUP_PAY_DATES")
                    .HasColumnType("numeric(1, 0)");

                entity.Property(e => e.SupPayMonths)
                    .HasColumnName("SUP_PAY_MONTHS")
                    .HasColumnType("numeric(1, 0)")
                    .HasDefaultValueSql("((1))");

                entity.Property(e => e.SupState)
                    .HasColumnName("SUP_STATE")
                    .HasMaxLength(4);

                entity.Property(e => e.SupTel)
                    .HasColumnName("SUP_TEL")
                    .HasMaxLength(13);

                entity.Property(e => e.SupZipCode)
                    .HasColumnName("SUP_ZIP_CODE")
                    .HasMaxLength(8);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.SupCodeNavigation)
                    .WithMany(p => p.SupplierMst)
                    .HasForeignKey(d => d.SupCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_COMPANYS_MST_SUPPLIER_MST");
            });

            modelBuilder.Entity<WhDeptMst>(entity =>
            {
                entity.HasKey(e => new { e.WhCode, e.DeptCode, e.StartDate })
                    .ForSqlServerIsClustered(false);

                entity.ToTable("WH_DEPT_MST");

                entity.Property(e => e.WhCode)
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3);

                entity.Property(e => e.DeptCode)
                    .HasColumnName("DEPT_CODE")
                    .HasMaxLength(5);

                entity.Property(e => e.StartDate)
                    .HasColumnName("START_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.HasOne(d => d.WhCodeNavigation)
                    .WithMany(p => p.WhDeptMst)
                    .HasForeignKey(d => d.WhCode)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_WH_MST_WH_DEPT_MST");

                entity.HasOne(d => d.DeptMst)
                    .WithMany(p => p.WhDeptMst)
                    .HasForeignKey(d => new { d.DeptCode, d.StartDate })
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_DEPT_MST_WH_DEPT_MST");
            });

            modelBuilder.Entity<WhMst>(entity =>
            {
                entity.HasKey(e => e.WhCode)
                    .ForSqlServerIsClustered(false);

                entity.ToTable("WH_MST");

                entity.Property(e => e.WhCode)
                    .HasColumnName("WH_CODE")
                    .HasMaxLength(3)
                    .ValueGeneratedNever();

                entity.Property(e => e.Address1)
                    .HasColumnName("ADDRESS1")
                    .HasMaxLength(40);

                entity.Property(e => e.Address2)
                    .HasColumnName("ADDRESS2")
                    .HasMaxLength(40);

                entity.Property(e => e.State)
                    .HasColumnName("STATE")
                    .HasMaxLength(4);

                entity.Property(e => e.UpdateDate)
                    .HasColumnName("UPDATE_DATE")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");

                entity.Property(e => e.Updater)
                    .HasColumnName("UPDATER")
                    .HasMaxLength(12);

                entity.Property(e => e.WhName)
                    .HasColumnName("WH_NAME")
                    .HasMaxLength(20);

                entity.Property(e => e.WhType)
                    .HasColumnName("WH_TYPE")
                    .HasMaxLength(1)
                    .HasDefaultValueSql("('N')");

                entity.Property(e => e.ZipCode)
                    .HasColumnName("ZIP_CODE")
                    .HasMaxLength(8);
            });
        }
    }
}
