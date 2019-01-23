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
npm install --save-dev @babel/core @babel/cli @babel/preset-env @babel/register @babel/polyfill cross-env webpack webpack-cli babel-loader 
```

### reactのセットアップ

```
npm install react react-dom @babel/preset-react jquery
npm i --save-dev webpack-dev-server html-webpack-plugin
```

### CSS Moduleのセットアップ

```
npm install --save-dev css-loader style-loader
```

### Jestのセットアップ

```
npm install --save-dev jest babel-jest regenerator-runtime babel-core@^7.0.0-bridge.0
```

### enzymeのセットアップ

```
npm install --save-dev enzyme enzyme-adapter-react-16 identity-obj-proxy
```

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [React](https://reactjs.org/)
- [新版で学ぶwebpack 4入門 – Babel 7でES2018環境の構築(React, Vue, Three.js, jQueryのサンプル付き)](https://ics.media/entry/16028)
- [Babelとwebpackを使ってES6でReactを動かすまでのチュートリアル](https://qiita.com/akirakudo/items/77c3cd49e2bf39da79dd)
- [Jest](https://jestjs.io/ja/)
- [Jest + enzymeで行うReactのユニットテスト（単体テスト）について](https://mae.chab.in/archives/60066)
- [Testing React with Jest and Enzyme I](https://medium.com/codeclan/testing-react-with-jest-and-enzyme-20505fec4675)
- [マルチカーソルを使わないVSCodeはただのVSCodeだ！〜解説編〜](http://mugi1.hateblo.jp/entry/2018/12/11/215808)
- [Enzyme cheatsheet](https://devhints.io/enzyme)