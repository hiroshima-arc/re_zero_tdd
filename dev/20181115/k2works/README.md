# 20181115

## 概要

Floobits から始めるテスト駆動開発

### 参加メンバー

- テストおじさん

## 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。

## 設計

### TODO リスト

- ~~1 から 100 まで数をプリントできるようにする。~~
- ~~3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。~~
- ~~5 の倍数のときは｢Buzz｣とプリントできるようにする。~~
- ~~3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。~~

## 開発

### ふりかえり

#### Keep

- テストファースト
- Floobits のリモートデモは結構使える

#### Problem

- while 文はデバッグがしんどい
- テストコードの重複
- Python のコンテナの仕様
- 変数を初期化しなかったことによる副作用の発生

#### Try

- 副作用のメリットとでデメリットを考える
- Python のコンテナの仕様を把握する

## 参照

- [Floobits](https://floobits.com/k2work)
- [Python プログラムの標準出力をテストする](https://qiita.com/Asayu123/items/6f2471aa5ebe597b2638)
- [テストクラス](https://docs.python.jp/3/library/unittest.html#unittest.TestCase.setUp)
