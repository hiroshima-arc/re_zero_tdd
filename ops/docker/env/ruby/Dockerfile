## Custom Dockerfile
FROM consol/ubuntu-xfce-vnc
ENV REFRESHED_AT 2018-03-18

# Switch to root user to install additional software
USER 0

## For Japanese
RUN locale-gen ja_JP.UTF-8
ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP:ja
ENV LC_ALL ja_JP.UTF-8

RUN apt-get update && \
    apt-get install -y language-pack-ja-base \
                       language-pack-ja \
                       ibus-mozc

## Install a vscode
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    wget \
    curl \
    git \
    gdebi

RUN wget -O vscode-amd64.deb https://go.microsoft.com/fwlink/?LinkID=760868
RUN yes | gdebi vscode-amd64.deb
RUN rm vscode-amd64.deb
RUN wget -O ~/vsls-reqs https://aka.ms/vsls-linux-prereq-script && chmod +x ~/vsls-reqs && ~/vsls-reqs

## For Development
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    build-essential \
    libssl-dev \
    libbz2-dev \
    libsqlite3-dev \
    libreadline-dev \
    zlib1g-dev \
    libasound2-dev \
    libxss1 \
    libxtst6

RUN chmod 0777 /usr/local/share
RUN chmod 0777 /usr/local/bin

## switch back to default user
USER 1000

# For Ruby
ENV RUBY_VER 2.5.3
RUN git clone https://github.com/sstephenson/rbenv ~/.rbenv
RUN git clone https://github.com/sstephenson/ruby-build.git ~/.rbenv/plugins/ruby-build
RUN ~/.rbenv/plugins/ruby-build/install.sh
RUN echo 'export PATH="/$HOME/.rbenv/bin:$PATH"' >> ~/.bash_profile
RUN echo 'eval "$(rbenv init -)"' >> ~/.bash_profile
RUN . ~/.bash_profile && \
         rbenv install $RUBY_VER  && \
         rbenv global $RUBY_VER
ENV PATH ~/.rbenv/shims:$PATH

RUN ~/.rbenv/shims/gem install bundler \
                               rake \
                               solargraph \
                               rubocop \
                               test_launcher \
                               ruby-debug-ide \
                               debase \
                               byebug \
                               pry \
                               pry-byebug \
                               minitest-reporters \
                               simplecov

### For vscode
RUN code --user-data-dir --install-extension ms-ceintl.vscode-language-pack-ja
RUN code --user-data-dir --install-extension ms-vsliveshare.vsliveshare
RUN code --user-data-dir --install-extension shan.code-settings-sync
RUN code --user-data-dir --install-extension davidanson.vscode-markdownlint
RUN code --user-data-dir --install-extension eamodio.gitlens
RUN code --user-data-dir --install-extension castwide.solargraph
RUN code --user-data-dir --install-extension rebornix.ruby
RUN code --user-data-dir --install-extension misogi.ruby-rubocop
RUN code --user-data-dir --install-extension blakeh.ruby-test-launcher