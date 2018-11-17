namespace :ci do
  desc 'CIイメージのビルド'
  task :build_image do
    sh 'docker build -t re-zero-tdd . -f ops/Dockerfile'
  end

  desc 'CIイメージのバージョン更新'
  task :update_image, [:ver] => [:build_image] do |_t, args|
    sh "docker tag re-zero-tdd:latest hiroshimaarc/re-zero-tdd:#{args[:ver]}"
  end

  desc 'CIイメージのデプロイ'
  task :deploy_image, [:ver] do |_t, args|
    sh "docker push hiroshimaarc/re-zero-tdd:#{args[:ver]}"
  end

  desc 'CI設定のチェック'
  task :check do
    sh 'circleci config validate -c .circleci/config.yml'
  end

  desc 'CIのローカル実行'
  task :local do
    sh 'circleci build .circleci/config.yml'
  end
end
