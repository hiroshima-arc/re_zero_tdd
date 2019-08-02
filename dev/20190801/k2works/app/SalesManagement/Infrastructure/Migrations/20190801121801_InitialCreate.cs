using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SalesManagement.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "ALTERNATE_PRODUCTS",
                columns: table => new
                {
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    ALT_PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    PRIORITY = table.Column<decimal>(type: "numeric(2, 0)", nullable: true, defaultValueSql: "((1))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ALTERNATE_PRODUCTS", x => new { x.PROD_CODE, x.ALT_PROD_CODE })
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "AUTO_NUMBER",
                columns: table => new
                {
                    SLIP_TYPE = table.Column<string>(maxLength: 2, nullable: false),
                    YEARMONTH = table.Column<DateTime>(type: "datetime", nullable: false),
                    LAST_SILP_NO = table.Column<decimal>(type: "numeric(4, 0)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_AUTO_NUMBER", x => new { x.SLIP_TYPE, x.YEARMONTH })
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "CATEGORY_TYPE",
                columns: table => new
                {
                    CATEGORY_TYPE_CODE = table.Column<string>(maxLength: 2, nullable: false),
                    CATE_TYPE_NAME = table.Column<string>(maxLength: 20, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CATEGORY_TYPE", x => x.CATEGORY_TYPE_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "COMPANY_GROUP_MST",
                columns: table => new
                {
                    COMP_GROUP_CODE = table.Column<string>(maxLength: 4, nullable: false),
                    GROUP_NAME = table.Column<string>(maxLength: 40, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_COMPANY_GROUP_MST", x => x.COMP_GROUP_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "COMPANYS_MST",
                columns: table => new
                {
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    COMP_NAME = table.Column<string>(maxLength: 40, nullable: false),
                    COMP_KANA = table.Column<string>(maxLength: 40, nullable: true),
                    SUP_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((0))"),
                    ZIP_CODE = table.Column<string>(maxLength: 8, nullable: true),
                    STATE = table.Column<string>(maxLength: 4, nullable: true),
                    ADDRESS1 = table.Column<string>(maxLength: 40, nullable: true),
                    ADDRESS2 = table.Column<string>(maxLength: 40, nullable: true),
                    NO_SALES_FLG = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((0))"),
                    WIDE_USE_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    COMP_GROUP_CODE = table.Column<string>(maxLength: 4, nullable: false),
                    MAX_CREDIT = table.Column<decimal>(type: "numeric(10, 0)", nullable: true),
                    TEMP_CREDIT_UP = table.Column<decimal>(type: "numeric(10, 0)", nullable: true, defaultValueSql: "((0))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_COMPANYS_MST", x => x.COMP_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "DEPT_MST",
                columns: table => new
                {
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    END_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "('2100/12/31')"),
                    DEP_NAME = table.Column<string>(maxLength: 40, nullable: true),
                    LAYER = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    UP_DIVISION_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    SLIT_YN = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_DEPT_MST", x => new { x.DEPT_CODE, x.START_DATE })
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "DESTINATIONS_MST",
                columns: table => new
                {
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    COMP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    DIST_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    DIST_NAME = table.Column<string>(maxLength: 40, nullable: false),
                    ZIP_CODE = table.Column<string>(maxLength: 8, nullable: true),
                    ADDRESS1 = table.Column<string>(maxLength: 40, nullable: true),
                    ADDRESS2 = table.Column<string>(maxLength: 40, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_DESTINATIONS_MST", x => new { x.COMP_CODE, x.DIST_NO, x.COMP_SUB_NO })
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "EMPLOYEE",
                columns: table => new
                {
                    EMP_CODE = table.Column<string>(maxLength: 10, nullable: false),
                    EMP_NAME = table.Column<string>(maxLength: 20, nullable: true),
                    EMP_KANA = table.Column<string>(maxLength: 40, nullable: true),
                    LOGIN_PASSWORD = table.Column<string>(maxLength: 8, nullable: true),
                    TEL = table.Column<string>(maxLength: 13, nullable: true),
                    FAX = table.Column<string>(maxLength: 13, nullable: true),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    OCCU_CODE = table.Column<string>(maxLength: 2, nullable: false),
                    APPROVAL_CODE = table.Column<string>(maxLength: 2, nullable: false),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_EMPLOYEE", x => x.EMP_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "INVOICE",
                columns: table => new
                {
                    INVOICE_NO = table.Column<string>(maxLength: 10, nullable: false),
                    INVOICED_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    CUST_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    LAST_RECEIVED = table.Column<decimal>(type: "numeric(13, 0)", nullable: true),
                    MONTH_SALES = table.Column<decimal>(type: "numeric(13, 0)", nullable: true),
                    MONTH_RECEIVED = table.Column<decimal>(type: "numeric(13, 0)", nullable: true),
                    MONTH_INVOICE = table.Column<decimal>(type: "numeric(13, 0)", nullable: true),
                    CMP_TAX = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    INVOICE_RECEIVED = table.Column<decimal>(type: "numeric(13, 0)", nullable: true, defaultValueSql: "((0))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_INVOICE", x => x.INVOICE_NO)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "PRODUCT_CATEGORY",
                columns: table => new
                {
                    CATEGORY_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    PROD_CATE_NAME = table.Column<string>(maxLength: 30, nullable: true),
                    LAYER = table.Column<decimal>(type: "numeric(2, 0)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PRODUCT_CATEGORY", x => x.CATEGORY_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "PRODUCTS",
                columns: table => new
                {
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    PROD_FULLNAME = table.Column<string>(maxLength: 40, nullable: false),
                    PROD_NAME = table.Column<string>(maxLength: 10, nullable: false),
                    PROD_KANA = table.Column<string>(maxLength: 20, nullable: false),
                    PROD_TYPE = table.Column<string>(maxLength: 1, nullable: true),
                    SERIAL_NO = table.Column<string>(maxLength: 40, nullable: true),
                    UNITPRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: false),
                    PO_PRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: true, defaultValueSql: "((0))"),
                    COST = table.Column<decimal>(type: "numeric(8, 0)", nullable: false),
                    TAX_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: false, defaultValueSql: "((1))"),
                    CATEGORY_CODE = table.Column<string>(maxLength: 8, nullable: true),
                    WIDE_USE_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    STOCK_MANAGE_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    STOCK_RESERVE_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    SUP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    SUP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PRODUCTS", x => x.PROD_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "SALES",
                columns: table => new
                {
                    SALES_NO = table.Column<string>(maxLength: 10, nullable: false),
                    ORDER_NO = table.Column<string>(maxLength: 10, nullable: false),
                    SALES_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    SALES_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    EMP_CODE = table.Column<string>(maxLength: 10, nullable: false),
                    SALES_AMNT = table.Column<decimal>(type: "numeric(13, 0)", nullable: false),
                    CMP_TAX = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    SLIP_COMMENT = table.Column<string>(maxLength: 1000, nullable: true),
                    UPDATED_NO = table.Column<decimal>(type: "numeric(10, 0)", nullable: true),
                    ORGNL_NO = table.Column<string>(maxLength: 10, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_SALES", x => x.SALES_NO)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "WH_MST",
                columns: table => new
                {
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    WH_NAME = table.Column<string>(maxLength: 20, nullable: true),
                    WH_TYPE = table.Column<string>(maxLength: 1, nullable: true, defaultValueSql: "('N')"),
                    ZIP_CODE = table.Column<string>(maxLength: 8, nullable: true),
                    STATE = table.Column<string>(maxLength: 4, nullable: true),
                    ADDRESS1 = table.Column<string>(maxLength: 40, nullable: true),
                    ADDRESS2 = table.Column<string>(maxLength: 40, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_WH_MST", x => x.WH_CODE)
                        .Annotation("SqlServer:Clustered", false);
                });

            migrationBuilder.CreateTable(
                name: "COMPANY_CATEGORY",
                columns: table => new
                {
                    CATEGORY_TYPE = table.Column<string>(maxLength: 2, nullable: false),
                    COMP_CATE_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    COMP_CATE_NAME = table.Column<string>(maxLength: 30, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_COMPANY_CATEGORY", x => new { x.COMP_CATE_CODE, x.CATEGORY_TYPE })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_CATEGORY_TYPE_COMPANY_CATEG",
                        column: x => x.CATEGORY_TYPE,
                        principalTable: "CATEGORY_TYPE",
                        principalColumn: "CATEGORY_TYPE_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "CREDIT_BALANCE",
                columns: table => new
                {
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    ORDER_BALANCE = table.Column<decimal>(type: "numeric(13, 0)", nullable: true, defaultValueSql: "((0))"),
                    REC_BALANCE = table.Column<decimal>(type: "numeric(13, 0)", nullable: true, defaultValueSql: "((0))"),
                    PAY_BALANCE = table.Column<decimal>(type: "numeric(13, 0)", nullable: true, defaultValueSql: "((0))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CREDIT_BALANCE", x => x.COMP_CODE)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_COMPANYS_MST_CREDIT_BALANC",
                        column: x => x.COMP_CODE,
                        principalTable: "COMPANYS_MST",
                        principalColumn: "COMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "CUSTOMERS_MST",
                columns: table => new
                {
                    CUST_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    CUST_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    CUST_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((0))"),
                    AR_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    AR_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    PAYER_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    PAYER_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    CUST_NAME = table.Column<string>(maxLength: 40, nullable: false),
                    CUST_KANA = table.Column<string>(maxLength: 40, nullable: true),
                    EMP_CODE = table.Column<string>(maxLength: 10, nullable: false),
                    CUST_USER_NAME = table.Column<string>(maxLength: 20, nullable: true),
                    CUST_USER_DEP_NAME = table.Column<string>(maxLength: 40, nullable: true),
                    CUST_ZIP_CODE = table.Column<string>(maxLength: 8, nullable: true),
                    CUST_STATE = table.Column<string>(maxLength: 4, nullable: true),
                    CUST_ADDRESS1 = table.Column<string>(maxLength: 40, nullable: true),
                    CUST_ADDRESS2 = table.Column<string>(maxLength: 40, nullable: true),
                    CUST_TEL = table.Column<string>(maxLength: 13, nullable: true),
                    CUST_FAX = table.Column<string>(maxLength: 13, nullable: true),
                    CUST_EMAIL = table.Column<string>(maxLength: 100, nullable: true),
                    CUST_AR_FLAG = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    CUST_CLOSE_DATE1 = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    CUST_PAY_MONTHS1 = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    CUST_PAY_DATES1 = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    CUST_PAY_METHOD1 = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    CUST_CLOSE_DATE2 = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    CUST_PAY_MONTHS2 = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    CUST_PAY_DATES2 = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    CUST_PAY_METHOD2 = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CUSTOMERS_MST", x => new { x.CUST_CODE, x.CUST_SUB_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_COMPANYS_MST_CUSTOMERS_MST",
                        column: x => x.CUST_CODE,
                        principalTable: "COMPANYS_MST",
                        principalColumn: "COMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "PRICEBYCUSTOMER",
                columns: table => new
                {
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    UNITPRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PRICEBYCUSTOMER", x => new { x.PROD_CODE, x.COMP_CODE })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_COMPANYS_MST_PRICEBYCUSTOME",
                        column: x => x.COMP_CODE,
                        principalTable: "COMPANYS_MST",
                        principalColumn: "COMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "SUPPLIER_MST",
                columns: table => new
                {
                    SUP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    SUP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    SUP_NAME = table.Column<string>(maxLength: 40, nullable: false),
                    SUP_KANA = table.Column<string>(maxLength: 40, nullable: true),
                    SUP_EMP_NAME = table.Column<string>(maxLength: 20, nullable: true),
                    SUP_DEP_NAME = table.Column<string>(maxLength: 40, nullable: true),
                    SUP_ZIP_CODE = table.Column<string>(maxLength: 8, nullable: true),
                    SUP_STATE = table.Column<string>(maxLength: 4, nullable: true),
                    SUP_ADDRESS1 = table.Column<string>(maxLength: 40, nullable: true),
                    SUP_ADDRESS2 = table.Column<string>(maxLength: 40, nullable: true),
                    SUP_TEL = table.Column<string>(maxLength: 13, nullable: true),
                    SUP_FAX = table.Column<string>(maxLength: 13, nullable: true),
                    SUP_EMAIL = table.Column<string>(maxLength: 100, nullable: true),
                    SUP_CLOSE_DATE = table.Column<decimal>(type: "numeric(2, 0)", nullable: false),
                    SUP_PAY_MONTHS = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    SUP_PAY_DATES = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    PAY_METHOD_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_SUPPLIER_MST", x => new { x.SUP_CODE, x.SUP_SUB_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_COMPANYS_MST_SUPPLIER_MST",
                        column: x => x.SUP_CODE,
                        principalTable: "COMPANYS_MST",
                        principalColumn: "COMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "BANK_ACUT_MST",
                columns: table => new
                {
                    BANK_ACUT_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    RECIVE_ACT_NAME = table.Column<string>(maxLength: 30, nullable: true),
                    APPL_START_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    APPL_END_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "('2100/12/31')"),
                    START_ACT_NAME = table.Column<string>(maxLength: 30, nullable: true),
                    RECIVE_BANK_ACT_TYPE = table.Column<string>(maxLength: 1, nullable: true),
                    RECIVE_ACT_NO = table.Column<string>(maxLength: 12, nullable: true),
                    BANK_ACT_TYPE = table.Column<string>(maxLength: 1, nullable: true),
                    ACT_NAME = table.Column<string>(maxLength: 20, nullable: true),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    A_BANK_CODE = table.Column<string>(maxLength: 4, nullable: true),
                    A_BANK_BLNC_CODE = table.Column<string>(maxLength: 3, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true),
                    UPDATE_PLG_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    UPDATE_PGM = table.Column<string>(maxLength: 50, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_BANK_ACUT_MST", x => x.BANK_ACUT_CODE)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_DEPT_MST_BANK_ACUT_MST",
                        columns: x => new { x.DEPT_CODE, x.START_DATE },
                        principalTable: "DEPT_MST",
                        principalColumns: new[] { "DEPT_CODE", "START_DATE" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "CREDIT",
                columns: table => new
                {
                    CREDIT_NO = table.Column<string>(maxLength: 10, nullable: false),
                    CREDIT_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    COMP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    PAY_METHOD_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    RECEIVED_AMNT = table.Column<decimal>(type: "numeric(13, 0)", nullable: true, defaultValueSql: "((0))"),
                    RECEIVED = table.Column<decimal>(type: "numeric(13, 0)", nullable: true, defaultValueSql: "((0))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true),
                    UPDATE_PLG_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    UPDATE_PGM = table.Column<string>(maxLength: 50, nullable: true),
                    BANK_ACUT_CODE = table.Column<string>(maxLength: 8, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CREDIT", x => x.CREDIT_NO)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_DEPT_MST_CREDIT",
                        columns: x => new { x.DEPT_CODE, x.START_DATE },
                        principalTable: "DEPT_MST",
                        principalColumns: new[] { "DEPT_CODE", "START_DATE" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "PU",
                columns: table => new
                {
                    PU_NO = table.Column<string>(maxLength: 10, nullable: false),
                    PU_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    SUP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    SUP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    EMP_CODE = table.Column<string>(maxLength: 10, nullable: false),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    PU_AMMOUNT = table.Column<decimal>(type: "numeric(10, 0)", nullable: true),
                    CMP_TAX = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    SLIP_COMMENT = table.Column<string>(maxLength: 1000, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())"),
                    PO_NO = table.Column<string>(maxLength: 10, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PU", x => x.PU_NO)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_EMPLOYEE_PU",
                        column: x => x.EMP_CODE,
                        principalTable: "EMPLOYEE",
                        principalColumn: "EMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_DEPT_MST_PU",
                        columns: x => new { x.DEPT_CODE, x.START_DATE },
                        principalTable: "DEPT_MST",
                        principalColumns: new[] { "DEPT_CODE", "START_DATE" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "PURCHASE_ORDERS",
                columns: table => new
                {
                    PO_NO = table.Column<string>(maxLength: 10, nullable: false),
                    PO_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    ORDER_NO = table.Column<string>(maxLength: 10, nullable: false),
                    SUP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    SUP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    EMP_CODE = table.Column<string>(maxLength: 10, nullable: false),
                    DUE_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    PO_AMNT = table.Column<decimal>(type: "numeric(10, 0)", nullable: true),
                    CMP_TAX = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    SLIP_COMMENT = table.Column<string>(maxLength: 1000, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PURCHASE_ORDERS", x => x.PO_NO)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_EMPLOYEE_PURCHASE_ORDERS",
                        column: x => x.EMP_CODE,
                        principalTable: "EMPLOYEE",
                        principalColumn: "EMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "INVOICE_DETAILS",
                columns: table => new
                {
                    INVOICE_NO = table.Column<string>(maxLength: 10, nullable: false),
                    SALES_NO = table.Column<string>(maxLength: 10, nullable: false),
                    ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_INVOICE_DETAILS", x => new { x.INVOICE_NO, x.SALES_NO, x.ROW_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_INVOICE_INVOICE_DETAILS",
                        column: x => x.INVOICE_NO,
                        principalTable: "INVOICE",
                        principalColumn: "INVOICE_NO",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "BOM",
                columns: table => new
                {
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    BOM_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    QUANTITY = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_BOM", x => x.PROD_CODE)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_PRODUCTS_BOM",
                        column: x => x.PROD_CODE,
                        principalTable: "PRODUCTS",
                        principalColumn: "PROD_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "SALES_DETAILS",
                columns: table => new
                {
                    SALES_NO = table.Column<string>(maxLength: 10, nullable: false),
                    ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    PROD_NAME = table.Column<string>(maxLength: 10, nullable: false),
                    UNITPRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: false),
                    DELIVERED_QTY = table.Column<decimal>(type: "numeric(4, 0)", nullable: true, defaultValueSql: "((0))"),
                    QUANTITY = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    DISCOUNT = table.Column<decimal>(type: "numeric(4, 0)", nullable: false),
                    INVOICED_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    INVOICE_NO = table.Column<string>(maxLength: 10, nullable: true),
                    INVOICE_DELAY_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    AUTO_JOURNAL_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_SALES_DETAILS", x => new { x.SALES_NO, x.ROW_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_SALES_SALES_DETAILS",
                        column: x => x.SALES_NO,
                        principalTable: "SALES",
                        principalColumn: "SALES_NO",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "LOCATION_MST",
                columns: table => new
                {
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    LOCATION_CODE = table.Column<string>(maxLength: 4, nullable: false),
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_LOCATION_MST", x => new { x.WH_CODE, x.LOCATION_CODE, x.PROD_CODE })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_PRODUCTS_LOCATION_MST",
                        column: x => x.PROD_CODE,
                        principalTable: "PRODUCTS",
                        principalColumn: "PROD_CODE",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_WH_MST_LOCATION_MST",
                        column: x => x.WH_CODE,
                        principalTable: "WH_MST",
                        principalColumn: "WH_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "STOCK",
                columns: table => new
                {
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    ROT_NO = table.Column<string>(maxLength: 20, nullable: false),
                    STOCK_TYPE = table.Column<string>(maxLength: 1, nullable: false, defaultValueSql: "('1')"),
                    QUALITY_TYPE = table.Column<string>(maxLength: 1, nullable: false, defaultValueSql: "('G')"),
                    ACTUAL = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    VALID = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    LAST_DELIVERY_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_STOCK", x => new { x.WH_CODE, x.PROD_CODE, x.ROT_NO, x.STOCK_TYPE, x.QUALITY_TYPE })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_WH_MST_STOCK",
                        column: x => x.WH_CODE,
                        principalTable: "WH_MST",
                        principalColumn: "WH_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "WH_DEPT_MST",
                columns: table => new
                {
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_WH_DEPT_MST", x => new { x.WH_CODE, x.DEPT_CODE, x.START_DATE })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_WH_MST_WH_DEPT_MST",
                        column: x => x.WH_CODE,
                        principalTable: "WH_MST",
                        principalColumn: "WH_CODE",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_DEPT_MST_WH_DEPT_MST",
                        columns: x => new { x.DEPT_CODE, x.START_DATE },
                        principalTable: "DEPT_MST",
                        principalColumns: new[] { "DEPT_CODE", "START_DATE" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "COMPANY_CATEGORY_GROUP",
                columns: table => new
                {
                    CATEGORY_TYPE = table.Column<string>(maxLength: 2, nullable: false),
                    COMP_CATE_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    COMP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_COMPANY_CATEGORY_GROUP", x => new { x.CATEGORY_TYPE, x.COMP_CODE, x.COMP_CATE_CODE })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_COMPANY_CATEGORY_COMPANY_CA",
                        columns: x => new { x.COMP_CATE_CODE, x.CATEGORY_TYPE },
                        principalTable: "COMPANY_CATEGORY",
                        principalColumns: new[] { "COMP_CATE_CODE", "CATEGORY_TYPE" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "ORDERS",
                columns: table => new
                {
                    ORDER_NO = table.Column<string>(maxLength: 10, nullable: false),
                    ORDER_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    CUST_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    CUST_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    EMP_CODE = table.Column<string>(maxLength: 10, nullable: false),
                    REQUIRED_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    CUSTORDER_NO = table.Column<string>(maxLength: 20, nullable: true),
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    ORDER_AMNT = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    CMP_TAX = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    SLIP_COMMENT = table.Column<string>(maxLength: 1000, nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ORDERS", x => x.ORDER_NO)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_EMPLOYEE_ORDERS",
                        column: x => x.EMP_CODE,
                        principalTable: "EMPLOYEE",
                        principalColumn: "EMP_CODE",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_WH_MST_ORDERS",
                        column: x => x.WH_CODE,
                        principalTable: "WH_MST",
                        principalColumn: "WH_CODE",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_CUSTOMERS_MST_ORDERS",
                        columns: x => new { x.CUST_CODE, x.CUST_SUB_NO },
                        principalTable: "CUSTOMERS_MST",
                        principalColumns: new[] { "CUST_CODE", "CUST_SUB_NO" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "PAY",
                columns: table => new
                {
                    PAY_NO = table.Column<string>(maxLength: 10, nullable: false),
                    PAY_DATE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true),
                    DEPT_CODE = table.Column<string>(maxLength: 5, nullable: false),
                    SUP_CODE = table.Column<string>(maxLength: 8, nullable: false),
                    SUP_SUB_NO = table.Column<decimal>(type: "numeric(2, 0)", nullable: true),
                    PAY_METHOD_TYPE = table.Column<decimal>(type: "numeric(1, 0)", nullable: true, defaultValueSql: "((1))"),
                    PAY_AMNT = table.Column<decimal>(type: "numeric(13, 0)", nullable: true),
                    CMP_TAX = table.Column<decimal>(type: "numeric(10, 0)", nullable: false),
                    COMPLETE_FLG = table.Column<decimal>(type: "numeric(1, 0)", nullable: false),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true),
                    START_DATE = table.Column<DateTime>(type: "datetime", nullable: true, defaultValueSql: "(getdate())")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PAY", x => x.PAY_NO)
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_DEPT_MST_PAY",
                        columns: x => new { x.DEPT_CODE, x.START_DATE },
                        principalTable: "DEPT_MST",
                        principalColumns: new[] { "DEPT_CODE", "START_DATE" },
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_SUPPLIER_MST_PAY",
                        columns: x => new { x.SUP_CODE, x.SUP_SUB_NO },
                        principalTable: "SUPPLIER_MST",
                        principalColumns: new[] { "SUP_CODE", "SUP_SUB_NO" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "PU_DETAILS",
                columns: table => new
                {
                    PU_ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PU_NO = table.Column<string>(maxLength: 10, nullable: false),
                    PU_ROW_DSP_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PO_ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    WH_CODE = table.Column<string>(maxLength: 3, nullable: false),
                    PROD_NAME = table.Column<string>(maxLength: 10, nullable: false),
                    PO_PRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: true, defaultValueSql: "((0))"),
                    PU_QUANTITY = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PU_DETAILS", x => new { x.PU_ROW_NO, x.PU_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_PRODUCTS_PU_DETAILS",
                        column: x => x.PROD_CODE,
                        principalTable: "PRODUCTS",
                        principalColumn: "PROD_CODE",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_PU_PU_DETAILS",
                        column: x => x.PU_NO,
                        principalTable: "PU",
                        principalColumn: "PU_NO",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_WH_MST_PU_DETAILS",
                        column: x => x.WH_CODE,
                        principalTable: "WH_MST",
                        principalColumn: "WH_CODE",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "PO_DETAILS",
                columns: table => new
                {
                    PO_ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PO_NO = table.Column<string>(maxLength: 10, nullable: false),
                    PO_ROW_DSP_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    ORDER_NO = table.Column<string>(maxLength: 10, nullable: false),
                    SO_ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    PROD_NAME = table.Column<string>(maxLength: 10, nullable: false),
                    PO_PRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: true, defaultValueSql: "((0))"),
                    PO_QT = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    RECIVED_QT = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    COMPLETE_FLG = table.Column<decimal>(type: "numeric(1, 0)", nullable: false),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PO_DETAILS_PKEY", x => new { x.PO_ROW_NO, x.PO_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_PURCHASE_ORDERS_PO_DETAILS",
                        column: x => x.PO_NO,
                        principalTable: "PURCHASE_ORDERS",
                        principalColumn: "PO_NO",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "ORDER_DETAILS",
                columns: table => new
                {
                    ORDER_NO = table.Column<string>(maxLength: 10, nullable: false),
                    SO_ROW_NO = table.Column<decimal>(type: "numeric(3, 0)", nullable: false),
                    PROD_CODE = table.Column<string>(maxLength: 16, nullable: false),
                    PROD_NAME = table.Column<string>(maxLength: 10, nullable: false),
                    UNITPRICE = table.Column<decimal>(type: "numeric(8, 0)", nullable: false),
                    QUANTITY = table.Column<decimal>(type: "numeric(4, 0)", nullable: false, defaultValueSql: "((1))"),
                    CMP_TAX_RATE = table.Column<decimal>(type: "numeric(3, 0)", nullable: true),
                    RESERVE_QTY = table.Column<decimal>(type: "numeric(4, 0)", nullable: true, defaultValueSql: "((0))"),
                    DELIVERY_ORDER_QTY = table.Column<decimal>(type: "numeric(4, 0)", nullable: true, defaultValueSql: "((0))"),
                    DELIVERED_QTY = table.Column<decimal>(type: "numeric(4, 0)", nullable: true, defaultValueSql: "((0))"),
                    COMPLETE_FLG = table.Column<decimal>(type: "numeric(1, 0)", nullable: false),
                    DISCOUNT = table.Column<decimal>(type: "numeric(4, 0)", nullable: false),
                    DELIVERY_DATE = table.Column<DateTime>(type: "datetime", nullable: true),
                    UPDATE_DATE = table.Column<DateTime>(type: "datetime", nullable: false, defaultValueSql: "(getdate())"),
                    UPDATER = table.Column<string>(maxLength: 12, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("ORDER_DETAILS_PKEY", x => new { x.ORDER_NO, x.SO_ROW_NO })
                        .Annotation("SqlServer:Clustered", false);
                    table.ForeignKey(
                        name: "FK_ORDERS_ORDER_DETAILS",
                        column: x => x.ORDER_NO,
                        principalTable: "ORDERS",
                        principalColumn: "ORDER_NO",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_BANK_ACUT_MST_DEPT_CODE_START_DATE",
                table: "BANK_ACUT_MST",
                columns: new[] { "DEPT_CODE", "START_DATE" });

            migrationBuilder.CreateIndex(
                name: "IX_COMPANY_CATEGORY_CATEGORY_TYPE",
                table: "COMPANY_CATEGORY",
                column: "CATEGORY_TYPE");

            migrationBuilder.CreateIndex(
                name: "IX_COMPANY_CATEGORY_GROUP_COMP_CATE_CODE_CATEGORY_TYPE",
                table: "COMPANY_CATEGORY_GROUP",
                columns: new[] { "COMP_CATE_CODE", "CATEGORY_TYPE" });

            migrationBuilder.CreateIndex(
                name: "IX_CREDIT_DEPT_CODE_START_DATE",
                table: "CREDIT",
                columns: new[] { "DEPT_CODE", "START_DATE" });

            migrationBuilder.CreateIndex(
                name: "IX_LOCATION_MST_PROD_CODE",
                table: "LOCATION_MST",
                column: "PROD_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_ORDERS_EMP_CODE",
                table: "ORDERS",
                column: "EMP_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_ORDERS_WH_CODE",
                table: "ORDERS",
                column: "WH_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_ORDERS_CUST_CODE_CUST_SUB_NO",
                table: "ORDERS",
                columns: new[] { "CUST_CODE", "CUST_SUB_NO" });

            migrationBuilder.CreateIndex(
                name: "IX_PAY_DEPT_CODE_START_DATE",
                table: "PAY",
                columns: new[] { "DEPT_CODE", "START_DATE" });

            migrationBuilder.CreateIndex(
                name: "IX_PAY_SUP_CODE_SUP_SUB_NO",
                table: "PAY",
                columns: new[] { "SUP_CODE", "SUP_SUB_NO" });

            migrationBuilder.CreateIndex(
                name: "IX_PO_DETAILS_PO_NO",
                table: "PO_DETAILS",
                column: "PO_NO");

            migrationBuilder.CreateIndex(
                name: "IX_PRICEBYCUSTOMER_COMP_CODE",
                table: "PRICEBYCUSTOMER",
                column: "COMP_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_PU_EMP_CODE",
                table: "PU",
                column: "EMP_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_PU_DEPT_CODE_START_DATE",
                table: "PU",
                columns: new[] { "DEPT_CODE", "START_DATE" });

            migrationBuilder.CreateIndex(
                name: "IX_PU_DETAILS_PROD_CODE",
                table: "PU_DETAILS",
                column: "PROD_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_PU_DETAILS_PU_NO",
                table: "PU_DETAILS",
                column: "PU_NO");

            migrationBuilder.CreateIndex(
                name: "IX_PU_DETAILS_WH_CODE",
                table: "PU_DETAILS",
                column: "WH_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_PURCHASE_ORDERS_EMP_CODE",
                table: "PURCHASE_ORDERS",
                column: "EMP_CODE");

            migrationBuilder.CreateIndex(
                name: "IX_WH_DEPT_MST_DEPT_CODE_START_DATE",
                table: "WH_DEPT_MST",
                columns: new[] { "DEPT_CODE", "START_DATE" });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "ALTERNATE_PRODUCTS");

            migrationBuilder.DropTable(
                name: "AUTO_NUMBER");

            migrationBuilder.DropTable(
                name: "BANK_ACUT_MST");

            migrationBuilder.DropTable(
                name: "BOM");

            migrationBuilder.DropTable(
                name: "COMPANY_CATEGORY_GROUP");

            migrationBuilder.DropTable(
                name: "COMPANY_GROUP_MST");

            migrationBuilder.DropTable(
                name: "CREDIT");

            migrationBuilder.DropTable(
                name: "CREDIT_BALANCE");

            migrationBuilder.DropTable(
                name: "DESTINATIONS_MST");

            migrationBuilder.DropTable(
                name: "INVOICE_DETAILS");

            migrationBuilder.DropTable(
                name: "LOCATION_MST");

            migrationBuilder.DropTable(
                name: "ORDER_DETAILS");

            migrationBuilder.DropTable(
                name: "PAY");

            migrationBuilder.DropTable(
                name: "PO_DETAILS");

            migrationBuilder.DropTable(
                name: "PRICEBYCUSTOMER");

            migrationBuilder.DropTable(
                name: "PRODUCT_CATEGORY");

            migrationBuilder.DropTable(
                name: "PU_DETAILS");

            migrationBuilder.DropTable(
                name: "SALES_DETAILS");

            migrationBuilder.DropTable(
                name: "STOCK");

            migrationBuilder.DropTable(
                name: "WH_DEPT_MST");

            migrationBuilder.DropTable(
                name: "COMPANY_CATEGORY");

            migrationBuilder.DropTable(
                name: "INVOICE");

            migrationBuilder.DropTable(
                name: "ORDERS");

            migrationBuilder.DropTable(
                name: "SUPPLIER_MST");

            migrationBuilder.DropTable(
                name: "PURCHASE_ORDERS");

            migrationBuilder.DropTable(
                name: "PRODUCTS");

            migrationBuilder.DropTable(
                name: "PU");

            migrationBuilder.DropTable(
                name: "SALES");

            migrationBuilder.DropTable(
                name: "CATEGORY_TYPE");

            migrationBuilder.DropTable(
                name: "WH_MST");

            migrationBuilder.DropTable(
                name: "CUSTOMERS_MST");

            migrationBuilder.DropTable(
                name: "EMPLOYEE");

            migrationBuilder.DropTable(
                name: "DEPT_MST");

            migrationBuilder.DropTable(
                name: "COMPANYS_MST");
        }
    }
}
