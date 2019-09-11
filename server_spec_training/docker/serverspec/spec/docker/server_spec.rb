require 'spec_helper'

describe command('whoami') do
  its(:stdout) { should match(/root/) }
end

describe 'httpd', if: os[:family] == 'redhat' do
  # NOTE: 上記は、docker側でyum install httpd -y すれば通る
  describe package('httpd') do
    it { should be_installed }
  end

  describe service('httpd') do
    # NOTE* 上記は、docker側でsystemctl enable httpd すれば通る
    it { should be_enabled }
    # NOTE: 上記は、systemctl start httpd すれば通る
    it { should be_running }
  end
end

# TODO: 以下は、Greenにならないので原因を調べる必要がある。
describe port(80) do
  it { should be_listening }
end
