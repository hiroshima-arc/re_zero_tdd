/* eslint-env mocha */

import {iterate} from "../src/fizzbuzz_controller";
import assert from "assert";
import {fizzBuzz} from "../src/fizzbuzz_model";
import {renderHtmlTable} from "../src/fizzbuzz_view";

const jsdom = require("jsdom");
const {JSDOM} = jsdom;
const {window} = new JSDOM("", {
  url: "http://localhost"
});
const {document} = new JSDOM("", {
  url: "http://localhost"
}).window;
const $ = require("jquery")(window);


describe("FizzBuzzController", function () {
  describe("#iterate()", function () {
    it("1から100までプリントする", function () {
      const array = iterate(100);
      assert.equal(1, array[0]);
      assert.equal("Buzz", array[99]);
    });
  });
});

describe("FizzBuzzModel", function () {
  describe("#fizzBuzz()", function () {
    it("3で割り切れる場合はFizzを返す", function () {
      assert.equal("Fizz", fizzBuzz(3));
      assert.equal(1, fizzBuzz(1));
    });

    it("5で割り切れる場合はBuzzを返す", function () {
      assert.equal("Buzz", fizzBuzz(5));
    });

    it("3または5で割り切れる場合はFizzBuzzを返す", function () {
      assert.equal("FizzBuzz", fizzBuzz(15));
    });
  });
});

describe("FizzBuzzView", function () {
  describe("#renderHtmlTable()", function () {
    it("HTMLテーブルがレンダリングされる", function () {
      const html = renderHtmlTable([1, 2, 3]);
      const expect = "<table><thead><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th></thead><tbody><tr><td>1</td><td>2</td><td>3</td></tbody></table>";
      assert.equal(expect, html);
    });
  });
});