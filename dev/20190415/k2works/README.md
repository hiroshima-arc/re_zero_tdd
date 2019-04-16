# 20190415

## 概要

### 参加メンバー

- k2works

## 仕様
> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。
> タイプごとに出力を切り替える、タイプ１は通常、タイプ２は数字のみ、タイプ３はFizzBuzzのみをプリントする。

## 設計

### TODO リスト
- [ ] 1 から 100 まで数をプリントできるようにする。
- [ ] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
- [ ] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
- [ ] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [ ] タイプ1の場合
    - [ ] 3 の倍数のときは数の代わりに｢Fizz｣をプリントできるようにする。
    - [ ] 5 の倍数のときは｢Buzz｣とプリントできるようにする。
    - [ ] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。
- [ ] タイプ2の場合
    - [ ] 3 の倍数のときは3をプリントできるようにする。
    - [ ] 5 の倍数のときは5をプリントできるようにする。
    - [ ] 3 と 5 両方の倍数の場合には値をプリントできるようにする。
- [ ] タイプ3の場合
    - [ ] 3 の倍数のときは数の代わりに｢FizzBuzz｣をプリントできるようにする。
    - [ ] 5 の倍数のときは｢FizzBuzz｣とプリントできるようにする。
    - [ ] 3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントできるようにする。

## 開発

### 構築

#### 開発パッケージのセットアップ

```bash
npm init
npm install npm-run-all watch foreman cpx rimraf --save-dev
touch Procfile
npm install --save-dev browser-sync connect-browser-sync
npx browser-sync init
```

```bash
mvn archetype:generate -DgroupId=org.hiroshima_arc -DartifactId=fizzbuzz -Dversion=1.0-SNAPSHOT \
       -DarchetypeGroupId=com.amazonaws.serverless.archetypes \
       -DarchetypeArtifactId=aws-serverless-springboot2-archetype \
       -DarchetypeVersion=1.3.1
cd fizzbuzz
mvn clean package
sam local start-api --template sam.yaml
```

http://localhost:3000/ping
```bash
$ curl -s http://127.0.0.1:3000/ping | python -m json.tool
```

### 配置

#### 開発バケットのセットアップ

```bash
npm run aws:s3:create
```

#### 開発Lambdaファンクションのビルド

```bash
npm run aws:sam:build
```

#### 開発Lambdaファンクションのデプロイ

```bash
npm run aws:sam:package
npm run aws:sam:deploy
npm run aws:sam:describe
```

#### 開発Lambdaファンクションのリリース

```bash
npm run aws:sam:release:dev
```

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [Quick start Spring Boot](https://github.com/awslabs/aws-serverless-java-container/wiki/Quick-start---Spring-Boot)