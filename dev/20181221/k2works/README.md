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

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [BABEL](https://babeljs.io/)
- [jsdom](https://github.com/jsdom/jsdom)
