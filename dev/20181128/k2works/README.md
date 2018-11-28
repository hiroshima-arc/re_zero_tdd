# 20181128

## 概要

### 参加メンバー


## 仕様

> 1 から 100 までの数をプリントするプログラムを書け。
> ただし 3 の倍数のときは数の代わりに｢Fizz｣と、5 の倍数のときは｢Buzz｣とプリントし、3 と 5 両方の倍数の場合には｢FizzBuzz｣とプリントすること。

## 設計

### TODO リスト

- [x] カウントが1から100までプリントできるようにする
- [x] 値が3の時はFizzをプリントできるようにする
- [ ] 値が5の時はBuzzをプリントできるようにする
- [ ] 値が3と5の時はFizzBuzzをプリントできるようにする

## 開発

### コミットメッセージフォーマット

Each commit message consists of a header, a body and a footer. The header has a special format that includes a type, a scope and a subject:
それぞれのコミットメッセージはヘッダー、ボディそしてフッターで構成されています。ヘッダーはタイプ、スコープそしてタイトルという特別なフォーマットで構成されています。

```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

The header is mandatory and the scope of the header is optional.
ヘッダーは必須でヘッダーのスコープは任意です。

Any line of the commit message cannot be longer 100 characters! This allows the message to be easier to read on GitHub as well as in various git tools.
コミットメッセージの長さは５０文字までに！そうすることでその他のgitツールと同様にGitHub上で読みやすくなります。

### タイプ

Must be one of the following:
以下に従うこと:

    feat: A new feature(新しい機能)
    fix: A bug fix(バグ修正)
    docs: Documentation only changes(ドキュメント変更のみ)
    style: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)(コードに影響を与えない変更)
    refactor: A code change that neither fixes a bug nor adds a feature(機能追加でもバグ修正でもないコードの変更)
    perf: A code change that improves performance(パフォーマンス改善のコード変更)
    test: Adding missing or correcting existing tests(テストの追加と既存テストの修正)
    chore: Changes to the build process or auxiliary tools and libraries such as documentation generation(ドキュメント生成などのライブラリ導入や自動化プロセスの構築)

### ふりかえり

#### Keep

#### Problem

#### Try

## 参照

- [どうしてプログラマに・・・プログラムが書けないのか?](http://www.aoky.net/articles/jeff_atwood/why_cant_programmers_program.htm)
