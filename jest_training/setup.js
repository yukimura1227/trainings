// setup.js
const puppeteer = require('puppeteer')
const os = require('os')
const fs = require('fs')
const path = require('path')
const mkdirp = require('mkdirp')
const DIR = path.join(os.tmpdir(), 'jest_puppeteer_global_setup')

module.exports = async function() {
  console.log('Setup Puppeteer')
  const browser = await puppeteer.launch();
  // store the browser instance so we can teardown it later
  // this global is only available in the teardown but not in TestEnvironments
  global.__BROWSER_GLOBAL__ = browser;

  // use the file system to expose the wsEndpoint for TestEnvironments
  mkdirp.sync(DIR);
  fs.writeFileSync(path.join(DIR, 'wsEndpoint'), browser.wsEndpoint());
};
