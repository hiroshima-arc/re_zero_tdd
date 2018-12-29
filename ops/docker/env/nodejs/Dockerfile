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
    apt-get install -y --no-install-recommends \
                       language-pack-ja-base \
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
    libxtst6 \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

RUN chmod 0777 /usr/local/share
RUN chmod 0777 /usr/local/bin

## switch back to default user
USER 1000

# For NodeJs
ENV NVM_DIR $HOME/.nvm
ENV NODE_VERSION 8.10.0
# Install nvm
RUN git clone https://github.com/creationix/nvm.git $NVM_DIR && \
    cd $NVM_DIR && \
    git checkout `git describe --abbrev=0 --tags`

# Install default version of Node.js
RUN . $NVM_DIR/nvm.sh && \
    nvm install v$NODE_VERSION && \
    nvm alias default v$NODE_VERSION && \
    nvm use default

# Add nvm.sh to .bashrc for startup...
ENV NODE_PATH $NVM_DIR/v$NODE_VERSION/lib/node_modules
ENV PATH      $NVM_DIR/versions/node/v$NODE_VERSION/bin:$PATH

### For vscode
RUN code --user-data-dir --install-extension ms-ceintl.vscode-language-pack-ja
RUN code --user-data-dir --install-extension ms-vsliveshare.vsliveshare
RUN code --user-data-dir --install-extension shan.code-settings-sync
RUN code --user-data-dir --install-extension davidanson.vscode-markdownlint
RUN code --user-data-dir --install-extension eamodio.gitlens

RUN code --user-data-dir --install-extension hbenl.vscode-mocha-test-adapter
RUN code --user-data-dir --install-extension orta.vscode-jest
RUN code --user-data-dir --install-extension eg2.vscode-npm-script
RUN code --user-data-dir --install-extension dbaeumer.vscode-eslint
RUN code --user-data-dir --install-extension prashaantt.node-tdd
RUN code --user-data-dir --install-extension hookyqr.beautify