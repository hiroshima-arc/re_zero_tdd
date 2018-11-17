## 書き方
# task <タスク名> , [<パラメータ名>, <パラメータ名> ... ] => [<前提タスク名>,<前提タスク名> ... ] do
#    # アクション
# end

# "hello" を表示するだけのタスク
task :hello do
  puts 'hello'
end

# "hello"の後に"world"を出力するタスク
task hellow_world: [:hello] do
  puts 'world'
end

# アクションなしのタスク
task all: %i[hellow_world echo]

# パラメータを受け付けるタスク
task :echo, [:message] => [:hello] do |_t, args|
  # ブロックへのパラメータとしてタスクオブジェクトとパラメータが渡される。
  puts args.message
end

# ネームスペースの中にタスクを定義する。
namespace :test do
  task :hello do
    puts 'hello'
  end
  task hello_world: [:hello] do
    puts 'world'
  end
end
