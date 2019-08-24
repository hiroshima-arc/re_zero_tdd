import { assert } from "chai";
import { greeting } from "../src/greeting";

describe("Hello, world", () => {
  it("say greeting", () => {
    assert.equal(greeting(), "hello, world");
  });
});
