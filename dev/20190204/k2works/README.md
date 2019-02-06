# 20190204

## 概要

フォームUIのテスト駆動開発

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

#### Keep

#### Problem

- チェックボックスの1と15を選択したら16を表示するで-16が計算される
- Formのsubmitを使ったテストが実行されない

#### Try

## 参照

- [入門JavaScript フロントエンドエンジニアになるための基本と実践スキル](https://rfs.jp/sb/javascript/jsbook/codepen-list.html)
- [Vue.js](https://jp.vuejs.org/)
- [Vue Test Utils](https://vue-test-utils.vuejs.org/ja/)
- [Vuejs formをサブミットするときのポイント](https://qiita.com/kimullaa/items/c60a5a229b9060177a48)
