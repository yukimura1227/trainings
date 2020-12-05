FROM ruby:2.6.6

RUN apt-get update -qq && \
    apt-get install -y build-essential \
                       libpq-dev \
                       nodejs

RUN mkdir /rails_app
ENV RAILS_APPLICATION_ROOT_DIR /rails_app
WORKDIR $RAILS_APPLICATION_ROOT_DIR

ADD ./initial_template/Gemfile $RAILS_APPLICATION_ROOT_DIR/Gemfile
ADD ./initial_template/Gemfile.lock $RAILS_APPLICATION_ROOT_DIR/Gemfile.lock

RUN bundle install
ADD . $RAILS_APPLICATION_ROOT_DIR
