const {defineSupportCode} = require('cucumber');
const fs = require('fs');
const { promisify } = require('util');
const webdriver = require('selenium-webdriver');
const { Builder, By, until } = webdriver;

defineSupportCode(function({After}) {
  After(async function () {
    let base64 = await this.driver.takeScreenshot();
    let buffer = Buffer.from(base64, 'base64');
    await promisify(fs.writeFile)('screenshot.jpg', buffer);
    return this.driver.quit();
  });
});