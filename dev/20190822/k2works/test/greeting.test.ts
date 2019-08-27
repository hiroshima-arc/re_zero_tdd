import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";
import { FizzBuzzData } from "../src/FizzBuzzData";

describe("FizzBuzz", () => {
  beforeEach(() => {
    this._data = new FizzBuzzData();
  });

  it("1から100までをプリントする", () => {
    this._data.list = FizzBuzz.generateList();
    assert.equal(this._data.list[0], "1");
    assert.equal(this._data.list[2], "Fizz");
    assert.equal(this._data.list[4], "Buzz");
    assert.equal(this._data.list[14], "FizzBuzz");
    assert.equal(this._data.list[99], "Buzz");
  });

  it("3で割り切れる場合はFizzをプリントする", () => {
    assert.equal(FizzBuzz.generate(3), "Fizz");
  });

  it("5で割り切れる場合はBuzzをプリントする", () => {
    assert.equal(FizzBuzz.generate(5), "Buzz");
  });

  it("15で割り切れる場合はFizzBuzzをプリントする", () => {
    assert.equal(FizzBuzz.generate(15), "FizzBuzz");
  });

  it("タイプ1は通常のパターンを返す", () => {
    assert.equal("Fizz", FizzBuzz.generate(3, 1));
  });

  it("タイプ1は通常のパターンのリストを返す", () => {
    this._data.list = FizzBuzz.generateList();
    assert.equal("Fizz", this._data.list[2]);
  });
});
