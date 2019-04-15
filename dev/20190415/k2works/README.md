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

## 開発
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

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [Quick start Spring Boot](https://github.com/awslabs/aws-serverless-java-container/wiki/Quick-start---Spring-Boot)