FROM node:18.13.0-slim as node

FROM rust:1.66-slim

COPY --from=node /usr/local/bin /usr/local/bin
COPY --from=node /usr/local/lib/node_modules/npm /usr/local/lib/node_modules/npm

RUN apt-get update -qq && \
  apt-get install -y

