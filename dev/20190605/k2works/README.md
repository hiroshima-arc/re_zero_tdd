# 20190605

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
npm install --save-dev mocha chai
```

Expressのセットアップ
```bash
mdir api/src
cd api/src
npm init -y
npm install express aws-serverless-express --save
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
