import { assert } from "chai";
import { FizzBuzz } from "../src/FizzBuzz";

describe("FizzBuzz", () => {
  it("1から100までをプリントする", () => {
    assert.equal(1, FizzBuzz.print1To100());
  });
});
