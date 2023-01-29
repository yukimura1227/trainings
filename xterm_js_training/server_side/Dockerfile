FROM node:18.12.1-slim
WORKDIR /usr/src/app

# for node-pty (for node-gyp)
RUN apt-get update || : && apt-get install -y \
  python3-pip \
  build-essential
