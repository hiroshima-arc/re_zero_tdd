# 20190806

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
npm install --save-dev prettier eslint jshint cross-env
npm install --save-dev browser-sync connect-browser-sync nodemon
npx browser-sync init
touch Procfile
```

#### アプリケーションのセットアップ

```bash
mkdir src
touch src/index.html
```

テストセットアップ
```bash
npm install --save-dev mocha chai @babel/register
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

- [HTML5　スマホアプリ開発の教科書](https://www.amazon.co.jp/HTML5-%E3%82%B9%E3%83%9E%E3%83%9B%E3%82%A2%E3%83%97%E3%83%AA%E9%96%8B%E7%99%BA%E3%81%AE%E6%95%99%E7%A7%91%E6%9B%B8-%E3%82%AF%E3%82%B8%E3%83%A9%E9%A3%9B%E8%A1%8C%E6%9C%BA-ebook/dp/B00NMEAHNG)
- [JavaScript Promiseの本](http://azu.github.io/promises-book/#ch2-promise-all)
