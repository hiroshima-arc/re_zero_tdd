# 20190620

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
npm install --save-dev prettier eslint babel-eslint jshint
npm install --save-dev browser-sync connect-browser-sync nodemon
npx browser-sync init
npx eslint --init
touch .jshintrc
touch Procfile
```

#### アプリケーションのセットアップ

```bash
mkdir src
touch src/index.html
npm run build
npm start
```

**[⬆ back to top](#構成)**

### 配置

**[⬆ back to top](#構成)**

### 運用

**[⬆ back to top](#構成)**

### 開発

#### 仕様
> Imagine a company of theatrical players who go out to various events performing plays. Typically, a customer will request a few plays and the company charges them based on the size of the audience and the kind of play they perform. There are currently two kinds of plays that the company performs: tragedies and comedies. As well as providing a bill for the performance, the company gives its customers "volume credits" which they can use for discounts on future performances—think of it as a customer loyalty mechanism.

#### 設計

##### TODO リスト

#### ふりかえり

##### Keep

>  When you have to add a feature to a program but the code is not structured in a convenient way, first refactor the program to make it easy to add the feature, then add the feature.

> Before you start refactoring, make sure you have a solid suite of tests. These tests must be self-checking. 

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照
