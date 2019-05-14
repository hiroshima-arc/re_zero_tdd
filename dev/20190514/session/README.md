# 20190514

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
npm init
npm install npm-run-all watch foreman cpx rimraf --save-dev
npm install --save-dev prettier eslint babel-eslint eslint-plugin-react@latest
npm install --save-dev browser-sync connect-browser-sync markdown-to-html
npx browser-sync init
touch Procfile
npx eslint --init
```

#### アプリケーションのセットアップ

```bash
npm install
npm run build
npm start
```

**[⬆ back to top](#構成)**

### 配置

**[⬆ back to top](#構成)**

### 運用

**[⬆ back to top](#構成)**

### 開発

|  |  |  |
| :------------- | :--------- | :--- |
| ユーザ名        | zero-tdd   |      |
| マネジメントコンソール         |  [AWS]( https://hiroshima-arc.signin.aws.amazon.com/console)  |      |
| Web IDE                     |    [Cloud9](https://ap-northeast-1.console.aws.amazon.com/cloud9/ide/8303dea7388a40018c1fa92c976b2824)  |      |

#### 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。

##### TODO リスト

- [ ] 1 から 100 まで数をプリントできるようにする。
- [ ] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [ ] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [ ] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。

#### 設計

##### TODO リスト

#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照
