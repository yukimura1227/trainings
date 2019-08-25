require 'serverspec'
require 'docker'

set :backend, :docker
set :docker_url, ENV['DOCKER_HOST']
image = Docker::Image.build_from_dir('.')
set :docker_image, image.id

Excon.defaults[:ssl_verify_peer] = false
