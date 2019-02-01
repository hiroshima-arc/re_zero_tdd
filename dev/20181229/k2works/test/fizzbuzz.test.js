/* eslint-env jest */
import assert from "assert";
import {iterate, fizzBuzz} from "../src/fizzbuzz_model";

describe("FizzBuzz", () => {
  describe("FizzBuzzController", () => {
    it("1から100までプリントするただし3で割り切れる場合はFizz5で割り切れる場合はBuzz3または5で割り切れる場合はFizzBuzz", () => {
      const array = iterate(100);
      assert.equal(array[0], 1);
      assert.equal(array[99], "Buzz");
      assert.equal(array[14], "FizzBuzz");
    });
  });

  describe("FizzBuzzModel", () => {
    it("3で割り切れる場合はFizzを返す", () => {
      assert.equal(fizzBuzz(3), "Fizz");
    });

    it("5で割り切れる場合はBuzzを返す", () => {
      assert.equal(fizzBuzz(5), "Buzz");
    });

    it("3または5で割り切れる場合はFizzBuzzを返す", () => {
      assert.equal(fizzBuzz(15), "FizzBuzz");
    });
  });
});