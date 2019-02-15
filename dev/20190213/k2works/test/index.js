module.exports = {
  before: function (browser, done) {
    server = require("../server")(done); // done is a callback that executes when the server is started
  },

  after: function () {
    server.close();
  },

  "トップページテスト" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .assert.containsText(".navbar-brand", "Mr. M COFFEE")
      .end();
  }
};