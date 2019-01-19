# 20181229

## 概要

モダン JavaScript フレームワーク(React)の導入

### 参加メンバー

- k2works

## 仕様

## 設計

### TODO リスト

- [x] npmパッケージのセットアップ
- [x] reactのセットアップ
- [ ] テスト

## 開発

### npmパッケージのセットアップ

```
npm init
npm install --save-dev @babel/core @babel/cli @babel/preset-env mocha @babel/register @babel/polyfill babel-plugin-istanbul cross-env nyc webpack webpack-cli babel-loader
```

### reactのセットアップ

```
npm install react react-dom @babel/preset-react
npm i -D webpack-dev-server html-webpack-plugin
```

### CSS Moduleのセットアップ

```
npm install --save-dev css-loader style-loader
```

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [React](https://reactjs.org/)
- [新版で学ぶwebpack 4入門 – Babel 7でES2018環境の構築(React, Vue, Three.js, jQueryのサンプル付き)](https://ics.media/entry/16028)
- [Babelとwebpackを使ってES6でReactを動かすまでのチュートリアル](https://qiita.com/akirakudo/items/77c3cd49e2bf39da79dd)
