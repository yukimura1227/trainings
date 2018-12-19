require 'spec_helper'

describe package('git') do
  it { should be_installed }
end

# 参考: set :disable_sudo, trueしているので、vagrantユーザになっていることを確認
describe command('whoami') do
  its(:stdout) { should match(/vagrant/) }
end

# 参考: 一時的にdisable_sudoを切り替える場合はletを使う
describe command('whoami') do
  let(:disable_sudo) { false }
  its(:stdout) { should match(/root/) }
end

describe command('rbenv --version') do
  its(:stdout) { should match(/rbenv 1\..*/) }
end

describe command('ruby -v') do
  its(:stdout) { should match(/ruby 2\.4\.0/) }
end
