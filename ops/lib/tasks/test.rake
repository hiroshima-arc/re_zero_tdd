namespace :test do
  work = File.expand_path(File.dirname(__FILE__) + '../../../../dev')

  desc 'Rubyテスト'
  task :ruby do
    cd work do
      Dir.glob("**/**/*.rb").each do |test|
        sh "ruby #{test}"
      end
    end
  end

  desc 'Pythonテスト'
  task :python do
    cd work do
      Dir.glob("**/**/*.py").each do |test|
        sh "python #{test}"
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

  desc 'JavaScriptテスト'
  task :nodejs do
    cd work do
      ['20181221/k2works'].each do |dir|
        cd dir do
          sh "npm install;npm test"
          sh "mv coverage/lcov.info ../../coverage/"
        end
      end
    end
  end


  desc 'Test all task'
  task all: %i[ruby python elixir]
end