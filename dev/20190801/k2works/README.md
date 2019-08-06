# 20190801

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| nodejs         | 8.10.0     |      |
| ASP.NET Core   | 2.2.0      |      |

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
npm install --save-dev browser-sync connect-browser-sync nodemon
npx browser-sync init
touch Procfile
```
#### アプリケーションのセットアップ

```bash
mkdir app
cd app
dotnet new webapp -o SalesManagement
cd SalesManagement
dotnet add package Microsoft.DotNet.Watcher.Tools
cd ..
dotnet new xunit -o SalesManagement.Tests
cd SalesManagement.Tests
dotnet add package Microsoft.AspNetCore.TestHost
dotnet add package Microsoft.AspNetCore.App
cd ..
cd ..
dotnet new sln -n SalesManagement
dotnet sln SalesManagement.sln add app/SalesManagement/SalesManagement.csproj 
dotnet sln SalesManagement.sln add app/SalesManagement.Tests/SalesManagement.Tests.csproj 
```

```bash
Scaffold-DbContext 'Server=localhost;Database=Sales;User=sa;Password=P@ssw0rd!' Microsoft.EntityFrameworkCore.SqlServer
Scaffold-DbContext 'Server=localhost;Initial Catalog=Sales;Integrated Security=True' Microsoft.EntityFrameworkCore.SqlServer -ContextDir Data -OutputDir Models
```

```bash
dotnet add package Microsoft.VisualStudio.Web.CodeGeneration.Design
dotnet aspnet-codegenerator razorpage -m DeptMst -dc SalesContext -udl -outDir Pages/ManagementResources/Departments --referenceScriptLibraries
dotnet aspnet-codegenerator razorpage -m Employee -dc SalesContext -udl -outDir Pages/ManagementResources/Employee --referenceScriptLibraries
dotnet aspnet-codegenerator razorpage -m Products -dc SalesContext -udl -outDir Pages/ManagementResources/Products --referenceScriptLibraries
```

**[⬆ back to top](#構成)**

### 配置

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
