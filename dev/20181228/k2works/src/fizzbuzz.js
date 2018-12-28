function iterate(count) {
  let array = [];
  [...Array(count + 1).keys()].forEach(function (n) {
    array.push(fizzBuzz(n));
  });
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

module.exports.iterate = iterate;
module.exports.fizzBuzz = fizzBuzz;