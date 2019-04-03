# 20190402

## 概要

SAMによるJava開発

### 参加メンバー

- k2works

## 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。
> タイプごとに出力を切り替える、タイプ１は通常、タイプ２は数字のみ、タイプ３はFizzBuzzのみをプリントする。

## 設計

### TODO リスト

- [x] 1 から 100 まで数をプリントできるようにする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする。
- [x] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [x] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [x] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [x] タイプ1は通常のプリントをできるようにする。
- [x] タイプ2は数字のみプリントできるようにする。
- [x] タイプ3はFizzBuzzのみプリントできるようにする。

## 開発

### 構築

```bash
sam init --runtime java
cd sam-app
sam build
sam loacl start-api
```

### 配置

```bash
aws s3 mb s3://re-zero-tdd-serverless
sam package \
    --output-template-file packaged.yaml \
    --s3-bucket re-zero-tdd-serverless
sam deploy \
    --template-file packaged.yaml \
    --stack-name sam-app \
    --capabilities CAPABILITY_IAM
aws cloudformation describe-stacks \
    --stack-name sam-app \
    --query 'Stacks[].Outputs'
```

### 運用

```bash
npm init
npm install npm-run-all watch foreman rimraf cpx --save-dev
touch Procfile
```

```bash
aws s3 rb s3://re-zero-tdd-serverless --force
aws cloudformation delete-stack --stack-name sam-app
```

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照
