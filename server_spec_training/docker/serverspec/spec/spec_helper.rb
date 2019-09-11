require 'serverspec'
require 'docker'

set :backend, :docker
set :docker_url, ENV['DOCKER_HOST']
# image = Docker::Image.build_from_dir('.')
# image = Docker::Image.get('67fa590cfc1c') # TODO: ここを動的に取得する方法をしらべる必要がある。
# set :docker_image, image.id

container = Docker::Container.get('ac3030d0bf01')
# set :docker_container, ENV['DOCKER_CONTAINER']
set :docker_container, container.id

Excon.defaults[:ssl_verify_peer] = false
