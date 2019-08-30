import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";
import { FizzBuzzType } from "../src/FizzBuzzType";

describe("FizzBuzz", () => {
  it("1から100までをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    fizzBuzz.generateList();
    assert.equal(fizzBuzz.list[0], "1");
    assert.equal(fizzBuzz.list[2], "Fizz");
    assert.equal(fizzBuzz.list[4], "Buzz");
    assert.equal(fizzBuzz.list[14], "FizzBuzz");
    assert.equal(fizzBuzz.list[99], "Buzz");
  });

  it("3で割り切れる場合はFizzをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal(fizzBuzz.generate(3), "Fizz");
  });

  it("5で割り切れる場合はBuzzをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal(fizzBuzz.generate(5), "Buzz");
  });

  it("15で割り切れる場合はFizzBuzzをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal(fizzBuzz.generate(15), "FizzBuzz");
  });

  it("タイプ1は通常のパターンを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal("Fizz", fizzBuzz.generate(3));
  });

  it("タイプ1は通常のパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    fizzBuzz.generateList();
    assert.equal("Fizz", fizzBuzz.list[2]);
  });

  it("タイプ2は数のみのパターンを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    assert.equal("3", fizzBuzz.generate(3));
  });

  it("タイプ2は数のみのパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    fizzBuzz.generateList();
    assert.equal("3", fizzBuzz.list[2]);
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    assert.equal(fizzBuzz.generate(15), "FizzBuzz");
    assert.equal(fizzBuzz.generate(3), "3");
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    fizzBuzz.generateList();
    assert.equal(fizzBuzz.list[14], "FizzBuzz");
    assert.equal(fizzBuzz.list[2], "3");
  });
});
