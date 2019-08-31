import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";
import { FizzBuzzListCommand } from "../src/FizzBuzzListCommand";
import { FizzBuzzType } from "../src/FizzBuzzType";
import { FizzBuzzValueCommand } from "../src/FizzBuzzValueCommand";

describe("FizzBuzz", () => {
  beforeEach(() => {
    this._command = new FizzBuzzValueCommand(FizzBuzzType.one);
  });

  it("1から100までをプリントする", () => {
    const command = new FizzBuzzListCommand(FizzBuzzType.one);
    const list = command.execute(100).getList();
    assert.equal(list[0].value, "1");
    assert.equal(list[2].value, "Fizz");
    assert.equal(list[4].value, "Buzz");
    assert.equal(list[14].value, "FizzBuzz");
    assert.equal(list[99].value, "Buzz");
  });

  it("3で割り切れる場合はFizzをプリントする", () => {
    assert.equal("Fizz", this._command.execute(3).getValue());
  });

  it("5で割り切れる場合はBuzzをプリントする", () => {
    assert.equal("Buzz", this._command.execute(5).getValue());
  });

  it("15で割り切れる場合はFizzBuzzをプリントする", () => {
    assert.equal("FizzBuzz", this._command.execute(15).getValue());
  });

  it("タイプ1は通常のパターンを返す", () => {
    const command = new FizzBuzzValueCommand(FizzBuzzType.one);
    assert.equal(command.execute(3).getValue(), "Fizz");
  });

  it("タイプ1は通常のパターンのリストを返す", () => {
    const fizzBuzz = new FizzBuzz(FizzBuzzType.one);
    fizzBuzz.generateList();
    assert.equal("Fizz", fizzBuzz.list[2].value);
  });

  it("タイプ2は数のみのパターンを返す", () => {
    const command = new FizzBuzzValueCommand(FizzBuzzType.two);
    assert.equal(command.execute(3).getValue(), "3");
  });

  it("タイプ2は数のみのパターンのリストを返す", () => {
    const command = new FizzBuzzListCommand(FizzBuzzType.two);
    const list = command.execute(5).getList();
    assert.equal("3", list[2].value);
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzを返す", () => {
    const command = new FizzBuzzValueCommand(FizzBuzzType.three);
    assert.equal(command.execute(15).getValue(), "FizzBuzz");
    assert.equal(command.execute(3).getValue(), "3");
  });

  it("タイプ3は15で割り切れる場合にFizzBuzzのパターンのリストを返す", () => {
    const command = new FizzBuzzListCommand(FizzBuzzType.three);
    const list = command.execute(15).getList();
    assert.equal(list[14].value, "FizzBuzz");
    assert.equal(list[2].value, "3");
  });
});
