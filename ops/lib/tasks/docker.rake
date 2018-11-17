# https://www.digitalocean.com/community/tutorials/how-to-remove-docker-images-containers-and-volumes

namespace :docker do
  desc '完全初期化'
  task :destroy do
    sh 'docker system prune -a'
  end

  desc 'イメージ削除'
  task :clear_image do
    sh 'docker rmi $(docker images -a -q)'
  end

  desc 'コンテナ削除'
  task :clear_container do
    sh 'docker rm $(docker ps -a -f status=exited -q)'
  end
end
