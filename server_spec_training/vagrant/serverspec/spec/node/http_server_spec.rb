require 'spec_helper'

describe package('httpd'), if: os[:family] == 'redhat' do
  it { should be_installed }
end

describe service('httpd'), if: os[:family] == 'redhat' do
  let(:disable_sudo) { false }
  it { should be_enabled }
  it { should be_running }
end

# describe service('apache2'), :if => os[:family] == 'ubuntu' do
#   it { should be_enabled }
#   it { should be_running }
# end
#
# describe package('apache2'), :if => os[:family] == 'ubuntu' do
#   it { should be_installed }
# end

describe port(80) do
  it { should be_listening }
end
