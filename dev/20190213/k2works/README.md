# 20190213

## 概要

Bootstrap 4 フロントエンド開発の教科書写経

### 参加メンバー

- k2works

## 仕様

## 設計

### TODO リスト

## 開発

開発サーバーのセットアップ

```
npm init
npm install --save-dev livereloadx
```

開発サーバーの起動
```
npm run server
```
[http://localhost:35729/](http://localhost:35729/)

E2Eテストのセットアップ

```
npm install --save-dev express
npm install --save-dev nightwatch
npm install --save-dev webdriver-manager
./node_modules/.bin/webdriver-manager update
./node_modules/.bin/webdriver-manager update --chrome
mkdir test
mkdir test/logs
mkdir test/reports
mkdir test/screenshots
```

E2Eテストの実行
```
npm run test
```

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照
- [Bootstrap 4 フロントエンド開発の教科書](https://gihyo.jp/book/2018/978-4-297-10020-9)
- [本書掲載サンプルコード](https://wings.msn.to/index.php/-/A-07/978-4-297-10020-9/)
- [Bootstrap](https://getbootstrap.com/)
- [Placehold.jp](http://placehold.jp/)
- [Emmet cheat sheet](https://docs.emmet.io/cheat-sheet/)
- [Nightwatch.js](http://nightwatchjs.org/)
- [Nightwatch.jsをE2Eテストフレームワークとして実プロジェクトに適用する時のtipsまとめ](https://blog.mmmcorp.co.jp/blog/2015/09/24/use-nightwatch/)
- [Learn Nightwatch: Complete Beginners Tutorial](https://github.com/dwyl/learn-nightwatch)
- [Chrome Headless ブラウザでテストを実行する](https://dev.oro.com/posts/2017/07/programming/testing-with-headless-chrome/)


