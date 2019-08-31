import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";
import { FizzBuzzType } from "../src/FizzBuzzType";

describe("FizzBuzz", () => {
  it("1から100までをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    fizzBuzz.generateList();
    assert.equal(fizzBuzz.list[0].value, "1");
    assert.equal(fizzBuzz.list[2].value, "Fizz");
    assert.equal(fizzBuzz.list[4].value, "Buzz");
    assert.equal(fizzBuzz.list[14].value, "FizzBuzz");
    assert.equal(fizzBuzz.list[99].value, "Buzz");
  });

  it("3で割り切れる場合はFizzをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal(fizzBuzz.generate(3).value, "Fizz");
  });

  it("5で割り切れる場合はBuzzをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal(fizzBuzz.generate(5).value, "Buzz");
  });

  it("15で割り切れる場合はFizzBuzzをプリントする", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal(fizzBuzz.generate(15).value, "FizzBuzz");
  });

  it("タイプ1は通常のパターンを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    assert.equal("Fizz", fizzBuzz.generate(3).value);
  });

  it("タイプ1は通常のパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    fizzBuzz.generateList();
    assert.equal("Fizz", fizzBuzz.list[2].value);
  });

  it("タイプ2は数のみのパターンを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    assert.equal("3", fizzBuzz.generate(3).value);
  });

  it("タイプ2は数のみのパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.two);
    fizzBuzz.generateList();
    assert.equal("3", fizzBuzz.list[2].value);
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    assert.equal(fizzBuzz.generate(15).value, "FizzBuzz");
    assert.equal(fizzBuzz.generate(3).value, "3");
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.three);
    fizzBuzz.generateList();
    assert.equal(fizzBuzz.list[14].value, "FizzBuzz");
    assert.equal(fizzBuzz.list[2].value, "3");
  });
});
