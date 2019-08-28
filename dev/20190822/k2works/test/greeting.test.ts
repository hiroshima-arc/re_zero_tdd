import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";

describe("FizzBuzz", () => {
  it("1から100までをプリントする", () => {
    const data = new FizzBuzz();
    data.list = FizzBuzz.generateList();
    assert.equal(data.list[0], "1");
    assert.equal(data.list[2], "Fizz");
    assert.equal(data.list[4], "Buzz");
    assert.equal(data.list[14], "FizzBuzz");
    assert.equal(data.list[99], "Buzz");
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
    const data = new FizzBuzz();
    data.list = FizzBuzz.generateList(1);
    assert.equal("Fizz", data.list[2]);
  });

  it("タイプ2は数のみのパターンを返す", () => {
    assert.equal("3", FizzBuzz.generate(3, 2));
  });

  it("タイプ2は数のみのパターンのリストを返す", () => {
    const data = new FizzBuzz();
    data.list = FizzBuzz.generateList(2);
    assert.equal("3", data.list[2]);
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzを返す", () => {
    assert.equal(FizzBuzz.generate(15, 3), "FizzBuzz");
    assert.equal(FizzBuzz.generate(3, 3), "3");
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す", () => {
    const data = new FizzBuzz();
    data.list = FizzBuzz.generateList(3);
    assert.equal(data.list[14], "FizzBuzz");
    assert.equal(data.list[2], "3");
  });
});
