# 20190618

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

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。
> タイプごとに出力を切り替える、タイプ１は通常、タイプ２は数字のみ、タイプ３は FizzBuzz の場合のみをプリントする。

#### 設計

##### TODO リスト

- [x] 1 から 100 まで数をプリントできるようにする。
- [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [x] タイプ 1 の場合
  - [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
  - [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
  - [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [x] タイプ 2 の場合
  - [x] 3 の倍数のときは数をプリントできるようにする。
  - [x] 5 の倍数のときは数をプリントできるようにする。
  - [x] 3 と 5 両方の倍数の場合には値をプリントできるようにする。
- [x] タイプ 3 の場合
  - [x] 3 の倍数のときは数をプリントできるようにする。
  - [x] 5 の倍数のときは数をプリントできるようにする。
  - [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。


#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照

- [JavaScriptにおける継承のパターン4種類の概要と対比](https://postd.cc/javascript-inheritance-patterns/)