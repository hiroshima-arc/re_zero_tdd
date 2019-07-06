# [20190705](https://github.com/hiroshima-arc/re_zero_tdd/pull/97)

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

様々な演目の劇を提供する会社を想像してみてください。特に特定の演目を希望する顧客に対して観客と演劇をもとに料金を設定します。現在、2種類の演劇（悲劇、喜劇）を提供しています。演劇を提供するのと同様に、顧客に対して将来の演劇を割引する"ボリュームクレジット"を顧客ロイヤルティサービスとして提供しています。

#### 設計

##### TODO リスト

#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照
- [Refactoring: Improving the Design of Existing Code (2nd Edition)](https://www.amazon.co.jp/Refactoring-Improving-Existing-Addison-Wesley-Signature/dp/0134757599/ref=pd_sbs_14_1/357-0788753-0519007?_encoding=UTF8&pd_rd_i=0134757599&pd_rd_r=531da6c3-3670-11e9-8479-6b76599af025&pd_rd_w=IozYn&pd_rd_wg=yCXVP&pf_rd_p=ad2ea29d-ea11-483c-9db2-6b5875bb9b73&pf_rd_r=T7JA13SSRSYEJJNQAT6D&psc=1&refRID=T7JA13SSRSYEJJNQAT6D)