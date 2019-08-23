require 'spec_helper'

# 参考: set :disable_sudo, trueしているので、vagrantユーザになっていることを確認
describe command('whoami') do
  its(:stdout) { should match(/vagrant/) }
end

# 参考: 一時的にdisable_sudoを切り替える場合はletを使う
describe command('whoami') do
  let(:disable_sudo) { false }
  its(:stdout) { should match(/root/) }
end
