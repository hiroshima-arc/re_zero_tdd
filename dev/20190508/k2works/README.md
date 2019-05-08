# 20190508

## 概要

### 参加メンバー

- k2works

## 仕様

## 設計

### TODO リスト

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
