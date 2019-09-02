import { assert, expect } from "chai";
import { FizzBuzzService } from "../src/Application/Service/FizzBuzzService";

describe("FizzBuzz", () => {
  beforeEach(() => {
    this._service = new FizzBuzzService();
  });

  it("1から100までをプリントする", () => {
    const list = this._service.generateList("one", 100).getList();
    assert.equal(list[0].value, "1");
    assert.equal(list[2].value, "Fizz");
    assert.equal(list[4].value, "Buzz");
    assert.equal(list[14].value, "FizzBuzz");
    assert.equal(list[99].value, "Buzz");
  });

  it("3で割り切れる場合はFizzをプリントする", () => {
    assert.equal(this._service.generate("one", 3).getValue(), "Fizz");
  });

  it("5で割り切れる場合はBuzzをプリントする", () => {
    assert.equal(this._service.generate("one", 5).getValue(), "Buzz");
  });

  it("15で割り切れる場合はFizzBuzzをプリントする", () => {
    assert.equal(this._service.generate("one", 15).getValue(), "FizzBuzz");
  });

  it("タイプ1は通常のパターンを返す", () => {
    assert.equal(this._service.generate("one", 3).getValue(), "Fizz");
  });

  it("タイプ1は通常のパターンのリストを返す", () => {
    assert.equal(
      this._service.generateList("one", 5).getList()[2].value,
      "Fizz"
    );
  });

  it("タイプ2は数のみのパターンを返す", () => {
    assert.equal(this._service.generate("two", 3).getValue(), "3");
  });

  it("タイプ2は数のみのパターンのリストを返す", () => {
    assert.equal(this._service.generateList("two", 5).getList()[2].value, "3");
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzを返す", () => {
    assert.equal(this._service.generate("three", 15).getValue(), "FizzBuzz");
    assert.equal(this._service.generate("three", 3).getValue(), "3");
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す", () => {
    assert.equal(
      this._service.generateList("three", 15).getList()[14].value,
      "FizzBuzz"
    );
    assert.equal(
      this._service.generateList("three", 15).getList()[2].value,
      "3"
    );
  });

  it("FizzBuzzValueはNullオブジェクトを返す", () => {
    const fizzbuzz = this._service.generate("one", 3);
    const list = fizzbuzz.getList();
    const empty = [];
    assert.deepEqual(list, empty);
  });

  it("FizzBuzzListはNullオブジェクトを返す", () => {
    const fizzbuzz = this._service.generateList("one", 100);
    assert.equal(fizzbuzz.getValue(), "");
  });

  it("FizzBuzzValueの値は正の値のみ許可する", () => {
    expect(() => this._service.generate("one", -3)).to.throw(
      Error,
      "FizzBuzzValue can't generate by minus number"
    );
  });

  it("FizzBuzzListの値は正の値のみ許可する", () => {
    expect(() => this._service.generateList("one", -100)).to.throw(
      Error,
      "FizzBuzzList can't generate by minus number"
    );
  });

  it("FizzBuzzListは101以上を許可しない", () => {
    expect(() => this._service.generateList("one", 101)).to.throw(
      Error,
      "FizzBuzzList can't generate over 100"
    );
  });
});
