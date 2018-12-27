/* eslint-env mocha */

import {iterate} from "../src/fizzbuzz_controller";
import assert from "assert";
import {fizzBuzz} from "../src/fizzbuzz_model";

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