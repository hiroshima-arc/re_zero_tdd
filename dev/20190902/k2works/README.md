# 20190902

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| nodejs         | 8.10.0     |      |

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
dotnet new react -o FizzBuzz 
dotnet new xunit -o FizzBuzz.Tests
cd FizzBuzz
dotnet add package Microsoft.DotNet.Watcher.Tools
cd ../..
dotnet new sln -n FizzBuzz
dotnet sln FizzBuzz.sln add app/FizzBuzz/FizzBuzz.csproj 
dotnet sln FizzBuzz.sln add app/FizzBuzz.Tests/FizzBuzz.Tests.csproj
```

```bash
cd app/FizzBuzz/ClientApp
yarn upgrade react-scripts --latest
yarn remove eslint eslint-config-react-app eslint-plugin-flowtype eslint-plugin-import eslint-plugin-jsx-a11y eslint-plugin-react babel-eslint
yarn add typescript @types/node @types/react @types/react-dom @types/jest
yarn add @types/react-router
yarn add --dev prettier tslint typescript tslint-config-prettier tslint-plugin-prettier
yarn add --dev npm-run-all watch foreman cpx rimraf
```
**[⬆ back to top](#構成)**

### 配置

**[⬆ back to top](#構成)**

### 運用

**[⬆ back to top](#構成)**

### 開発

#### 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること

#### 設計

##### TODO リスト

- [x] 1 から 100 まで数をプリントできるようにする。
- [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。

#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照
- [ASP.NET Core で React プロジェクト テンプレートを使用する](https://docs.microsoft.com/ja-jp/aspnet/core/client-side/spa/react?view=aspnetcore-2.2&tabs=visual-studio)
- [How to use Typescript with the ASP.NET Core 2.x React Project Template](https://jonhilton.net/new-aspnet-core-react-project/)
- [enum 型の代わりに Enumeration クラスを使用する](https://docs.microsoft.com/ja-jp/dotnet/architecture/microservices/microservice-ddd-cqrs-patterns/enumeration-classes-over-enum-types)
- [値オブジェクトを実装する](https://docs.microsoft.com/ja-jp/dotnet/architecture/microservices/microservice-ddd-cqrs-patterns/implement-value-objects})