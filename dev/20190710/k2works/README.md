# 20190710

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
npm install --save-dev prettier @prettier/plugin-python
npm install --save-dev browser-sync connect-browser-sync nodemon
npx browser-sync init
touch Procfile
```

#### アプリケーションのセットアップ

```bash
mkdir src
touch src/index.html
sam init --runtime python3.7 -n api
```

**[⬆ back to top](#構成)**

### 配置

**[⬆ back to top](#構成)**

### 運用

**[⬆ back to top](#構成)**

### 開発

#### 仕様

顧客が借りたビデオのレンタル料金を計算して計算書を印刷する。

+ ビデオレンタルの料金を計算して計算書を印刷するプログラム
+ システムにはどの映画を何日間借りるかが入力される。
+ 貸出の日数によって料金が計算され、映画の分類が判定される。
+ 映画の分類は３つある。一般向け、子供向け、新作。
+ レンタルポイントも印刷される。新作かどうかによってポイント計算の仕方が異なる。

#### 設計

##### TODO リスト

#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照
- [Serverless Python Web Applications With AWS Lambda and Flask](https://spiegelmock.com/2018/09/06/serverless-python-web-applications-with-aws-lambda-and-flask/)
- [AWSGI](https://github.com/slank/awsgi)