# 20190508

## 概要

### 参加メンバー

- k2works

## 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。

## 設計

### TODO リスト

- [ ] 1 から 100 まで数をプリントできるようにする。
- [ ] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [ ] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [ ] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。

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
