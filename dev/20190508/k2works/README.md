# 20190508

## 概要

### 参加メンバー

- k2works

## 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。
> タイプごとに出力を切り替える、タイプ１は通常、タイプ２は数字のみ、タイプ３はFizzBuzzの場合のみをプリントする。

## 設計

### TODO リスト

- [x] 1 から 100 まで数をプリントできるようにする。
- [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [x] タイプ1の場合
  - [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
  - [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
  - [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [x] タイプ2の場合
  - [x] 3 の倍数のときは数をプリントできるようにする。
  - [x] 5 の倍数のときは数をプリントできるようにする。
  - [x] 3 と 5 両方の倍数の場合には値をプリントできるようにする。
- [x] タイプ3の場合
  - [x] 3 の倍数のときは数をプリントできるようにする。
  - [x] 5 の倍数のときは数をプリントできるようにする。
  - [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
  
## 開発

開発環境セットアップ

```bash
cd dev/20190508/k2works/
npm init
npm install npm-run-all watch foreman cpx rimraf --save-dev
touch Procfile
npm install --save-dev browser-sync connect-browser-sync markdown-to-html
npx browser-sync init
```

PHP環境セットアップ

```bash
composer require --dev phpunit/phpunit ^8
./vendor/bin/phpunit --version
```

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [PHPUnit マニュアル](https://phpunit.readthedocs.io/ja/latest/index.html)
- [PhpStorm を使っていて、PHPUnit のテストケースでメソッド名を日本語つかいたい場合の noinspection](https://qiita.com/youhey/items/467669ddd564cb1d1854)
- [PHPで文字列リテラルに式展開](https://qiita.com/tadsan/items/e4796449c736cfb5c9bd)
- [【PHP超入門】名前空間（namespace・use）について](https://qiita.com/7968/items/1e5c61128fa495358c1f)
- [PHPのincludeとrequireの使い方と違いを比較](https://www.flatflag.nir87.com/include-598)
- [PHPerがドメイン駆動設計と関数型プログラミングを学んで得たもの(前編)](https://qiita.com/nunulk/items/53290a9d995f8a67fbda)