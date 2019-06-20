require('chromedriver');
const seleniumWebdriver = require('selenium-webdriver');
const {defineSupportCode} = require('cucumber');
const chrome = require('selenium-webdriver/chrome');
const firefox = require('selenium-webdriver/firefox');

const screen = {
  width: 900,
  height: 650
};

function CustomWorld() {
  if (process.env.NODE_ENV === 'browser') {
    this.driver = new seleniumWebdriver.Builder()
      .forBrowser('chrome')
      .build();
  } else {
    this.driver = new seleniumWebdriver.Builder()
      .forBrowser('chrome')
      .setChromeOptions(new chrome.Options().headless().windowSize(screen))
      .setFirefoxOptions(new firefox.Options().headless().windowSize(screen))
      .build();
  }
}

defineSupportCode(function({setWorldConstructor}) {
  setWorldConstructor(CustomWorld)
});