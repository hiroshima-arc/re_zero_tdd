const assert = chai.assert;
suite("FizzBuzzTest", () => {
  test("1から100までをプリントする", () => {
    let list = generateList();
    assert.equal(1, list[0]);
    assert.equal(100, list[99]);
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

function generateList() {
  return [...Array(101).keys()].slice(1).map(ix => ix);
}

function fizzBuzz(number) {
  if (number % 15 === 0) return "FizzBuzz";
  if (number % 3 === 0) return "Fizz";
  if (number % 5 === 0) return "Buzz";
  return number;
}
