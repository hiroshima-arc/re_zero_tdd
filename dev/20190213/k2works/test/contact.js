module.exports = {
  before: function (browser, done) {
    server = require("../server")(done); // done is a callback that executes when the server is started
  },

  after: function () {
    server.close();
  },

  "Contactが表示される" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .click("#navbar-content > ul:nth-child(2) > li > a")
      .assert.containsText("body > main > div.container > h2", "Contact")
      .end();
  },

  "お問い合わせフォームに入力できる" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .click("#navbar-content > ul:nth-child(2) > li > a")
      .setValue("#name", "お名前")
      .setValue("#email", "mail@hoge.com")
      .click("#raido3")
      .click("#category option[value='category2']")
      .setValue("#message", "あああ\nいいい\nううう")
      .click("body > main > div.py-3 > div > form > div.form-group.row.justify-content-end > div > button")
      .end();
  },
};