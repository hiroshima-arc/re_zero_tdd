# 20190605

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| nodejs         | 10.16.0     |      |

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
npm install --save-dev prettier eslint babel-eslint
npm install --save-dev browser-sync connect-browser-sync nodemon
npx browser-sync init
npx eslint --init
touch Procfile
```

#### アプリケーションのセットアップ

```bash
mkdir src
touch src/index.html
sam init -r nodejs10.x -n api
```

テストセットアップ
```bash
npm install --save-dev mocha chai supertest unit.js
npm install --save-dev cucumber selenium-webdriver chromedriver
npm install --save-dev aws-sdk aws-sdk-mock
mkdir -p features/step_definitions
mkdir -p features/support
touch cucumber.js
```

Webpackセットアップ
```bash
npm install --save-dev @babel/core @babel/cli @babel/preset-env @babel/register @babel/polyfill babel-plugin-istanbul cross-env nyc webpack webpack-cli webpack-dev-server babel-loader css-loader html-webpack-plugin mini-css-extract-plugin copy-webpack-plugin clean-webpack-plugin                                                                                                                                                                                                                                                                 
```

Expressのセットアップ
```bash
mdir api/src
cd api/src
npm init -y
npm install express aws-serverless-express aws-sdk --save
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

- [Bootstrap Editor](https://www.venezia-works.com/bst/index.html)
