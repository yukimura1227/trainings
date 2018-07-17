const puppeteer = require('puppeteer');

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  await page.goto('http://yukimura1227.blog.fc2.com/');
  await page.screenshot({path: 'test_result/example.png'});

  await browser.close();
})();
