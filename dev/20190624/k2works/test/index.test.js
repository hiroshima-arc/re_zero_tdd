import { expect } from "chai";
import {greeting} from '../src/index';
describe("HelloWorld", () => {
  it("greeting", () => {
    expect("hello, world").to.equal(greeting());
  });
});
