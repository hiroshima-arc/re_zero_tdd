# 20190722

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| nodejs         | 8.10.0     |      |
| ASP.NET Core   | 2.2.0     |      |

## 構成

- [構築](#構築)
- [配置](#配置)
- [運用](#運用)
- [開発](#開発)

## 詳細

### 構築

#### 開発パッケージのセットアップ

```bash
npm init -y
npm install --save-dev npm-run-all watch foreman cpx rimraf markdown-to-html
npm install --save-dev prettier prettier-plugin-csharp
npm install --save-dev browser-sync connect-browser-sync
npx browser-sync init
touch Procfile
```

#### アプリケーションのセットアップ

```bash
mkdir app
cd app
dotnet add package Microsoft.DotNet.Watcher.Tools
dotnet new webapp -o ContosoUniversity
dotnet new xunit -o ContosoUniversity.Tests
cd ..
dotnet new sln -n ConntosUniversity
dotnet sln ConntosUniversity.sln add app/ContosoUniversity/ContosoUniversity.csproj 
dotnet sln ConntosUniversity.sln add app/ContosoUniversity.Tests/ContosoUniversity.Tests.csproj 
```

**[⬆ back to top](#構成)**

### 配置

#### アプリケーションのデプロイ

```bash
npm run aws:eb:app:release
```

**[⬆ back to top](#構成)**

### 運用

**[⬆ back to top](#構成)**

### 開発

#### 仕様

#### 設計

##### TODO リスト

#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照
- [ASP.NET Core での Entity Framework Core を使用した Razor ページ - チュートリアル ](https://docs.microsoft.com/ja-jp/aspnet/core/data/ef-rp/intro?view=aspnetcore-2.2&tabs=visual-studio)
- [dotnet テストと xUnit を使用した .NET Core での単体テスト C#](https://docs.microsoft.com/ja-jp/dotnet/core/testing/unit-testing-with-dotnet-test?toc=%2Faspnet%2Fcore%2Ftoc.json&bc=%2Faspnet%2Fcore%2Fbreadcrumb%2Ftoc.json&view=aspnetcore-2.2)
- [Quickstart: Compose and ASP.NET Core with SQL Server](https://docs.docker.com/compose/aspnet-mssql-compose/)
- [SQL Server in Docker](https://github.com/microsoft/mssql-docker)
- [コマンドラインでSQL Serverを使う最低限のメモ](https://qiita.com/zaburo/items/6edf7c05c5d4f5e039eb)