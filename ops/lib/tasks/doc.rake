namespace :doc do
  desc "マークダウンファイルのフォーマット"
  task :format do
    sh 'npm run format'
  end
end
