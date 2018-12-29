# 20181221

## 概要

ES6モジュールの分割とテストフレームワークの導入

### 参加メンバー

- k2works

## 仕様

## 設計

### TODO リスト

- [x] トランスパイラのセットアップ
- [x] テストフレームワークのセットアップ
- [x] テストの作成

## 開発

### トランスパイラのセットアップ

npmセットアップ

```
npm init
```

Babel CLIセットアップ

```
npm install --save-dev @babel/core @babel/cli
npm install @babel/preset-env --save-dev
```

トランスパイラの実行

```
npm run build
```

### テストフレームワークのセットアップ

```
npm install --save-dev mocha
npm install --save-dev @babel/register
npm install --save-dev @babel/polyfill
```

### パッケージバンドラーのセットアップ

```
npm i -D webpack webpack-cli webpack-dev-server babel-loader
npm install jquery
```

### コードカバレッジのセットアップ

```
npm i babel-plugin-istanbul cross-env nyc --save-de
```

### ふりかえり

#### Keep

- ES6
- Babel & webpack

#### Problem

- jQueryとテストの相性が悪い
- domのテストがうまく行かなかった

#### Try

## 参照

- [BABEL](https://babeljs.io/)
- [istanbul](https://istanbul.js.org/docs/tutorials/es2015/)
- [最新版で学ぶwebpack 4入門 – JavaScriptのモジュールバンドラ](https://ics.media/entry/12140/3)
- [ES6モジュールのインポートとエクスポート](https://qiita.com/dondoko-susumu/items/55f54582d31b0f0fd687)
