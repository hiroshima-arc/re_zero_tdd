namespace :doc do
  desc "マークダウンファイルのフォーマット"
  task :format do
    sh 'npm run format'
  end

  desc "AsciiDocビルド"
  task :build do
    sh 'gradle asciidoctor'
  end

  desc "AsciiDocローカル実行"
  task local: [:build] do
    sh 'echo http://localhost:35729'
    sh 'gradle livereload'
  end
end
