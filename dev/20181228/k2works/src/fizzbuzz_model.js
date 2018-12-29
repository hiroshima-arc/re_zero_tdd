const constants = require("./constants");
const MAX_COUNT = constants.FIZZ_BUZZ_MAX_COUNT;

function execute() {
  iterate(MAX_COUNT).forEach((value) => {
    console.log(value);
  });
}

function iterate(count) {
  let array = [];
  [...Array(count + 1).keys()].forEach((n) => {
    array.push(fizzBuzz(n));
  });
  array.shift();
  return array;
}

function fizzBuzz(number) {
  let value = number;

  if ((number % 3 === 0) && (number % 5 === 0)) {
    value = "FizzBuzz";
  } else if (number % 3 === 0) {
    value = "Fizz";
  } else if (number % 5 === 0) {
    value = "Buzz";
  }

  return value;
}

module.exports.execute = execute;
module.exports.iterate = iterate;
module.exports.fizzBuzz = fizzBuzz;