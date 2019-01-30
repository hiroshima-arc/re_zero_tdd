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

  desc 'JavaScriptカバレージ'
  task :nodejs do
    cd work do
      %w(20181221/k2works
         20181228/k2works).each do |dir|
        cd dir do
          sh "mv coverage/lcov.info ../../coverage/"
        end
      end
    end
  end

  desc 'Test all coverage'
  task all: %i[python nodejs]
end