const chai = require("chai");
const assert = chai.assert;
const { generateList, fizzBuzz } = require("./FizzBuzz");

suite("FizzBuzzTest", () => {
  test("1から100までをプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz15で割り切れる場合はFizzBuzzをプリントする", () => {
    let list = generateList();
    assert.equal(1, list[0]);
    assert.equal("Fizz", list[2]);
    assert.equal("Buzz", list[4]);
    assert.equal("FizzBuzz", list[14]);
    assert.equal("Buzz", list[99]);
  });
  test("3で割り切れる場合はFizzをプリントする", () => {
    assert.equal("Fizz", fizzBuzz(3));
  });
  test("5で割り切れる場合はBuzzをプリントする", () => {
    assert.equal("Buzz", fizzBuzz(5));
  });
  test("15で割り切れる場合はFizzBuzzをプリントする", () => {
    assert.equal("FizzBuzz", fizzBuzz(15));
  });
});
