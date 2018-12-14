namespace :coverage do
  work = File.expand_path(File.dirname(__FILE__) + '../../../../dev')

  desc 'Pythonカバレージ'
  task :python do
    cd work do
      Dir.glob("**/**/*.py").each do |test|
        sh "coverage run #{test}"
        sh "coverage xml"
      end
    end
  end

  desc 'Elixirテスト'
  task :elixir do
    cd work do
      Dir.glob("**/**/*.exs").each do |test|
        sh "elixir #{test}"
      end
    end
  end

  desc 'Test all task'
  task all: %i[ruby python elixir]
end