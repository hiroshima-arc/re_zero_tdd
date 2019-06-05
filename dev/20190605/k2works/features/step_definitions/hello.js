const chai = require('chai');
const assert = chai.assert;
const { Given, When, Then } = require('cucumber');
const { By } = require('selenium-webdriver');

When('{string}にアクセスした', async function(string) {
  await this.driver.get(`http://localhost:3000`);
  const title = await this.driver.getTitle();
  assert.equal('Title', title);
});

Then('{string}が表示される', async function(string) {
  const actual = await this.driver.findElement(By.css('#app')).getText();
  assert.equal(string, actual);
});