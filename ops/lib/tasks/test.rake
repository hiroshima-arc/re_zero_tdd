namespace :test do
  desc 'Rubyテスト'
  task :ruby do
    cd "dev" do
      sh "ruby 20181026/FizzBuzzTest.rb"
      sh "ruby 20181129/k2works/main_test.rb"
      sh "ruby 20181129/hiroshima_rb/main.rb"
    end
  end

  desc 'Pythonテスト'
  task :python do
    cd "dev" do
      sh "python 20181109/main_test.py"
      sh "python 20181109/replay_main_test.py"
      sh "python 20181114/k2works/main_test.py"
      sh "python 20181115/k2works/main_test.py"
      sh "python 20181116/session/main_test.py"
      sh "python 20181116/replay/fizz_buzz_test.py"
    end
  end

  desc 'Elixirテスト'
  task :elixir do
    cd "dev" do
      sh "elixir 20181112/FizzBuzzTest.exs"
    end
  end

  desc 'Test all task'
  task all: %i[ruby python elixir]
end