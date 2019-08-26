import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";

describe("FizzBuzz", () => {
  it("1から100までをプリントする", () => {
    const list: number[] = FizzBuzz.print1To100();
    assert.equal(list[0], 1);
    assert.equal(list[99], 100);
  });

  it("3で割り切れる場合はFizzをプリントする", () => {
    assert.equal("Fizz", FizzBuzz.generate(3));
  });
});
