# 20190716

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| nodejs         | 8.10.0     |      |
| ASP.NET Core   | 2.1.0     |      |

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
mkdir src
touch src/index.html
mkdir api
cd api
dotnet new --install "Amazon.Lambda.Templates"
dotnet new serverless.AspNetCoreWebAPI -n todo
cd todo/src/todo
dotnet add package Microsoft.DotNet.Watcher.Tools
dotnet add todo.csproj package Swashbuckle.AspNetCore -v 5.0.0-rc2
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
- [ASP.NET Core を使って Web API を作成する](https://docs.microsoft.com/ja-jp/aspnet/core/web-api/?view=aspnetcore-2.2)
- [Developing .NET Core AWS Lambda functions](https://aws.amazon.com/jp/blogs/compute/developing-net-core-aws-lambda-functions/)
- [AWS Lambda for .NET Core](https://github.com/aws/aws-lambda-dotnet)
- [Dotnet Watch (Like Nodemon For NodeJS)](https://davidemanske.com/dotnet-watch-like-nodemon-for-nodejs/)
- [AWS Elastic Beanstalk を使用した ASP.NET Core アプリケーションのデプロイ](https://docs.aws.amazon.com/ja_jp/elasticbeanstalk/latest/dg/dotnet-core-tutorial.html)
- [ASP.NET Core のコントローラーのロジックをテストする](https://docs.microsoft.com/ja-jp/aspnet/core/mvc/controllers/testing?view=aspnetcore-2.2)
- [TestingControllersSample](https://github.com/aspnet/AspNetCore.Docs/tree/master/aspnetcore/mvc/controllers/testing/samples)
- [Unit Testing in ASP.NET Core Web API](https://code-maze.com/unit-testing-aspnetcore-web-api/)
- [Moq : Mocking Framework for .NET](https://qiita.com/usamik26/items/42959d8b95397d3a8ffb)
- [ASP.NET Core MVC で Web アプリを作成する](https://docs.microsoft.com/ja-jp/aspnet/core/tutorials/first-mvc-app/?view=aspnetcore-2.2)
- [Docker コンテナーで ASP.NET Core をホストする](https://docs.microsoft.com/ja-jp/aspnet/core/host-and-deploy/docker/?view=aspnetcore-2.2)
- [dotnet sh](https://docs.microsoft.com/ja-jp/dotnet/core/tools/dotnet-sln)
- [マルチコンテナのDocker](https://docs.aws.amazon.com/ja_jp/elasticbeanstalk/latest/dg/create_deploy_docker_ecs.html)
- [Nginx 搭載の Linux で ASP.NET Core をホストする](https://docs.microsoft.com/ja-jp/aspnet/core/host-and-deploy/linux-nginx?view=aspnetcore-2.2)
- [Elastic Beanstalk Docker using AWS EC2 Container Registry (ECR)](https://blog.eq8.eu/til/elastic-beanstalk-docker-using-aws-ec2-container-registry-ecr.html)