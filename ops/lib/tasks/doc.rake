namespace :doc do
  desc "READMEファイルのセットアップ"
  task :setup, [:member] do |_t, args|
    require 'erb'
    require 'fileutils'

    title = (Time.now).strftime("%Y%m%d")
    if args.member.nil?
      member = ENV['USER']
    else
      member = args.member
    end
    OUT_DIR = "dev/#{title}/#{member}"
    OUT_FILE = "#{OUT_DIR}/README.md"
    TEMPLATE_DIR = "ops/lib/tasks/templates".freeze

    FileUtils.mkdir_p(OUT_DIR)

    @title = title
    @member = member
    erb_str = File.read("#{TEMPLATE_DIR}/README.md.erb")
    render = ERB.new(erb_str)
    result = render.result

    File.open(OUT_FILE, "w") do |f|
      f.write(result)
    end
  end

  desc "マークダウンファイルのフォーマット"
  task :format do
    sh 'npm run format'
  end

  desc "マークダウンファイルのチェック"
  task :check do
    sh 'npm run check'
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
