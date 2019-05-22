# 20190520

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| nodejs         | 8.10.0     |      |
| java           | 8          |      |

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
npm install --save-dev prettier prettier-plugin-java
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
gradle init --type java-application
```

**[⬆ back to top](#構成)**

### 配置

**[⬆ back to top](#構成)**

### 運用

**[⬆ back to top](#構成)**

### 開発

```bash
npm run install
npm run build
npm start
```

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

#### ふりかえり

##### Keep

##### Problem

##### Try

**[⬆ back to top](#構成)**

## 参照

- [Build Init Plugin](https://docs.gradle.org/4.10-rc-2/userguide/build_init_plugin.html#sec:build_init_types)
- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/#scratch)
- [Using JUnit5](https://docs.gradle.org/4.6/userguide/java_plugin.html#using_junit5)
- [モダンなJava開発ガイド (2018年版)](https://qiita.com/yoichiwo7/items/17190cb440ab7d253cea#linterstatic-code-checker%E3%82%92%E4%BD%BF%E7%94%A8%E3%81%99%E3%82%8B)
- [Gradle プロジェクトで静的解析ツールを使う](https://qiita.com/toastkidjp/items/180e69d49cbdccb7d3fe#warning-%E6%8C%87%E6%91%98%E3%81%8C%E5%A4%9A%E3%81%99%E3%81%8E%E3%82%8B%E5%A0%B4%E5%90%88%E3%81%A7%E3%82%82%E3%83%93%E3%83%AB%E3%83%89%E3%82%92%E5%A4%B1%E6%95%97%E6%89%B1%E3%81%84%E3%81%AB%E3%81%97%E3%81%AA%E3%81%84)
- [20. Developer Tools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html)