namespace :test do
  work = File.expand_path(File.dirname(__FILE__) + '../../../../dev')

  desc 'Rubyテスト'
  task :ruby do
    cd work do
      %w(20190704/k2works).each do |dir|
        cd dir do
          sh "npm install"
          sh "npm run build:api"
          sh "npm run test"
        end
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
      %w(20181221/k2works
         20181228/k2works
         20181229/k2works
         20190130/k2works).each do |dir|
        cd dir do
          sh "npm install;npm test"
        end
      end
    end
  end

  desc 'Javaテスト'
  task :java do
    cd work do
      %w(20190402/k2works/sam-app
         ).each do |dir|
        cd dir do
          sh "npm install;npm test"
        end
      end
    end
  end
  desc 'Test all task'
  task all: %i[ruby python elixir nodejs java]
end