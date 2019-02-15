module.exports = {
  before: function (browser, done) {
    server = require("../server")(done); // done is a callback that executes when the server is started
  },

  after: function () {
    server.close();
  },

  "Topが表示される" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .assert.containsText(".navbar-brand", "Mr. M COFFEE")
      .end();
  },

  "Aboutが表示される" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .click("#navbar-content > ul.navbar-nav.mr-auto > li:nth-child(2) > a")
      .assert.containsText("#about > div > div.row.mb-4 > div.col-md-8.mb-3 > h3", "Mr. M COFFEEについて")
      .end();
  },

  "Menuが表示される" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .click("#navbar-content > ul.navbar-nav.mr-auto > li:nth-child(3) > a")
      .click("#tab-menu01")
      .assert.containsText("#panel-menu01 > div > div.col-md-7.order-md-2 > h4", "COFFEE")
      .click("#tab-menu02")
      .assert.containsText("#panel-menu02 > div > div.col-md-7.order-md-2 > h4", "MORNING")
      .click("#tab-menu03")
      .assert.containsText("#panel-menu03 > div > div.col-md-7.order-md-2 > h4", "LUNCH")
      .click("#tab-menu04")
      .assert.containsText("#panel-menu04 > div > div.col-md-7.order-md-2 > h4", "CAKE")
      .end();
  },

  "Couponが表示される" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .click("#navbar-content > ul.navbar-nav.mr-auto > li:nth-child(4) > a")
      .assert.containsText("#coupon > div > h3", "Coupon")
      .end();
  },

  "Informationが表示される" : function (browser) {
    browser
      .url("http://localhost:3000")
      .waitForElementVisible("body")
      .click("#navbar-content > ul.navbar-nav.mr-auto > li.nav-item.dropdown.show > div > a:nth-child(1)")
      .assert.containsText("#shop > h4", "Shop")
      .click("#navbar-content > ul.navbar-nav.mr-auto > li.nav-item.dropdown.show > div > a:nth-child(2)")
      .assert.containsText("#access > h4", "Access")
      .end();
  },
};