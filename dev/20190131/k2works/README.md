# 20190131

## 概要

トランスパイラ・バンドラを使わずブラウザとテキストエディタのみで実装するSPAテスト駆動開発

### 参加メンバー

- k2works

## 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。

## 設計

### TODO リスト

- [x] 1 から 100 まで数をプリントできるようにする。
- [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。

## 開発

```
npm install -g livereloadx
livereloadx -s
```
[http://localhost:35729/](http://localhost:35729/)

### ふりかえり

- モダンブラウザならコンポーネントのテストまでできることがわかった。
- フロントエンドにはReactよりVueのほうが理解しやすいかもしれない。

#### Keep

#### Problem

#### Try

## 参照
- [どうしてプログラマに・・・プログラムが書けないのか?](http://www.aoky.net/articles/jeff_atwood/why_cant_programmers_program.htm)
- [【Vue.js】【TDD】ブラウザだけでVueテストを書きましょう](https://qiita.com/webpack_master/items/1219b61eb0dd924cb1b8)
- [ブラウザのリロードを自動化するLiveReloadの導入方法](https://blog.nzakr.com/use-livereload/)
- [Vue.js](https://jp.vuejs.org/)
- [Vue Test Utils](https://vue-test-utils.vuejs.org/ja/)
- [Mocha](https://mochajs.org/)
- [Chai](https://www.chaijs.com/)