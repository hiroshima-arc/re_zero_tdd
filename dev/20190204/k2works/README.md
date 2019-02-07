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
- コンポーネント間の値の連携にハマる

#### Try

## 参照

- [入門JavaScript フロントエンドエンジニアになるための基本と実践スキル](https://rfs.jp/sb/javascript/jsbook/codepen-list.html)
- [Vue.js](https://jp.vuejs.org/)
- [Vue Test Utils](https://vue-test-utils.vuejs.org/ja/)
- [Vuejs formをサブミットするときのポイント](https://qiita.com/kimullaa/items/c60a5a229b9060177a48)
- [Vue.js2.x系で親子コンポーネント間でデータの受け渡しをする方法](https://kuroeveryday.blogspot.com/2016/10/vuejs-components-emit-events.html)
- [ンポーネントで v-model を使う](https://jp.vuejs.org/v2/guide/components.html#%E3%82%B3%E3%83%B3%E3%83%9D%E3%83%BC%E3%83%8D%E3%83%B3%E3%83%88%E3%81%A7-v-model-%E3%82%92%E4%BD%BF%E3%81%86)
- [.sync 修飾子](https://jp.vuejs.org/v2/guide/components-custom-events.html#sync-%E4%BF%AE%E9%A3%BE%E5%AD%90)
- [親コンポーネントと子コンポーネントで双方向バインディングする](https://qiita.com/Sa2Knight/items/544b3f157108b96033fe)