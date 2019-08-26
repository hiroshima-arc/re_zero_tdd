import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";

describe("FizzBuzz", () => {
  it("1から100までをプリントする", () => {
    const list: string[] = FizzBuzz.generateList();
    assert.equal(list[0], "1");
    assert.equal(list[2], "Fizz");
    assert.equal(list[4], "Buzz");
    assert.equal(list[14], "FizzBuzz");
    assert.equal(list[99], "Buzz");
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
});
