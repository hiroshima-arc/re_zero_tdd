# Contributing to re_zero_tdd

これはこのリポジトリの contribute.md です。ご覧いただきありがとうございます。このリポジトリにコミットやプルリクエストをするときにお読み下さい。

## このリポジトリの使い方

### dev/ ディレクトリ

テスト駆動開発で開発する練習や教材やセッション(ハンズオンの記録)をコミットするには、ディレクトリ `dev/` をお使い下さい。

`dev/` の下に日付のディレクトリ (`YYYYMMDD` 形式。例: `20181210`) を作り、さらにその下に作る人の名前 (ユーザ名など) のディレクトリを作って下さい。

例: `dev/20181209/k2works/`

## コミットメッセージのフォーマット

コミットメッセージの書き方には様々な流儀がありますが、このリポジトリでは今のところ[Angularルールでやってみる](https://github.com/hiroshima-arc/re_zero_tdd/issues/10#issuecomment-439269671)ことにしています。

<https://github.com/angular/angular.js/blob/master/DEVELOPERS.md>

それぞれのコミットメッセージはヘッダ、ボディ、フッタで構成されています。ヘッダはタイプ、スコープ、タイトルというフォーマットで構成されています。

```
<タイプ>(<スコープ>): <タイトル>
<空行>
<ボディ>
<空行>
<フッタ>
```

ヘッダは必須です。
ヘッダのスコープは任意です。
コミットメッセージの長さは50文字までにしてください。(そうすることでその他のGitツールと同様にGitHub上で読みやすくなります。)

コミットのタイプは次を用いて下さい。

- feat: A new feature (新しい機能)
- fix: A bug fix (バグ修正)
- docs: Documentation only changes (ドキュメント変更のみ)
- style: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc) (コードに影響を与えない変更)
- refactor: A code change that neither fixes a bug nor adds a feature (機能追加でもバグ修正でもないコード変更)
- perf: A code change that improves performance (パフォーマンスを改善するコード変更)
- test: Adding missing or correcting existing tests (存在しないテストの追加、または既存のテストの修正)
- chore: Changes to the build process or auxiliary tools and libraries such as documentation generation (ドキュメント生成のような、補助ツールやライブラリやビルドプロセスの変更)
