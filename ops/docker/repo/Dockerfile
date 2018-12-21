FROM amazonlinux:1

ENV HOME /root

RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN yum update -y && \
    yum install -y git \
                   curl \
                   build-essential \
                   libssl-dev \
                   tar  \
                   which \
                   zip \
                   unzip \
                   gcc \
                   gcc-c++  \
                   make  \
                   openssl-devel  \
                   bzip2-devel  \
                   zlib-devel  \
                   readline-devel  \
                   sqlite-devel  \
                   python-devel  \
                   python3-dev  \
                   bzip2  \
                   automake  \
                   autoconf  \
                   ncurses-devel  \
                   procps

RUN curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py && \
    python get-pip.py && \
    pip install awscli

# For Ruby
ENV RUBY_VER 2.5.3
RUN git clone https://github.com/sstephenson/rbenv $HOME/.rbenv
RUN git clone https://github.com/sstephenson/ruby-build.git $HOME/.rbenv/plugins/ruby-build
RUN $HOME/.rbenv/plugins/ruby-build/install.sh
RUN echo 'export PATH="/$HOME/.rbenv/bin:$PATH"' >> $HOME/.bash_profile
RUN echo 'eval "$(rbenv init -)"' >> $HOME/.bash_profile
RUN source  $HOME/.bash_profile && \
            rbenv install $RUBY_VER  && \
            rbenv global $RUBY_VER
ENV PATH $HOME/.rbenv/shims:$PATH
RUN gem install bundler \
                rake \
                minitest-reporters \
                simplecov

# For NodeJs
ENV NVM_DIR $HOME/.nvm
ENV NODE_VERSION 8.10.0
# Install nvm
RUN git clone https://github.com/creationix/nvm.git $NVM_DIR && \
    cd $NVM_DIR && \
    git checkout `git describe --abbrev=0 --tags`
# Install default version of Node.js
RUN source $NVM_DIR/nvm.sh && \
    nvm install v$NODE_VERSION && \
    nvm alias default v$NODE_VERSION && \
    nvm use default
# Add nvm.sh to .bashrc for startup...
RUN echo "source ${NVM_DIR}/nvm.sh" > $HOME/.bashrc && \
    source $HOME/.bashrc
ENV NODE_PATH $NVM_DIR/v$NODE_VERSION/lib/node_modules
ENV PATH      $NVM_DIR/versions/node/v$NODE_VERSION/bin:$PATH

# For Python
ENV PYTHON_VER 3.6.0
RUN curl -L https://github.com/pyenv/pyenv-installer/raw/master/bin/pyenv-installer | bash
RUN echo 'export PATH="/$HOME/.pyenv/bin:$PATH"' >> $HOME/.bash_profile
RUN echo 'eval "$(pyenv init -)"' >> $HOME/.bash_profile
RUN echo 'eval "$(pyenv virtualenv-init -)"' >> $HOME/.bash_profile
RUN source  $HOME/.bash_profile && \
            pyenv install $PYTHON_VER  && \
            pyenv global $PYTHON_VER
ENV PATH $HOME/.pyenv/shims:$PATH
RUN pip install --upgrade pip && \
    pip install coverage

# For Elixir
ENV ERLANG_VER 21.1.1
ENV ELIXIR_VER 1.7.4
RUN git clone https://github.com/asdf-vm/asdf.git $HOME/.asdf --branch v0.6.0
RUN echo 'export PATH="/$HOME/.asdf/bin:$PATH"' >> $HOME/.bash_profile
RUN echo -e '\n. $HOME/.asdf/asdf.sh' >> ~/.bashrc_profile
RUN echo -e '\n. $HOME/.asdf/completions/asdf.bash' >> $HOME/.bashrc_profile
RUN source  $HOME/.bash_profile && \
            asdf plugin-add erlang  && \
            asdf plugin-add elixir  && \
            asdf install erlang $ERLANG_VER  && \
            asdf global erlang $ERLANG_VER  && \
            asdf install elixir $ELIXIR_VER  && \
            asdf global elixir $ELIXIR_VER
ENV PATH $HOME/.asdf/shims:$PATH