const puppeteer = require('puppeteer');

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  page.setViewport({width: 1200, height: 800})

  await page.goto('http://yukimura1227.blog.fc2.com/');
  await page.waitForNavigation({waitUntil:'networkidle2', timeout:5000})
            .catch(e => console.log('timeout exceed. proceed to next operation'))
  await page.screenshot({path: 'test_result/example.png', fullPage: true});

  await browser.close();
})();
