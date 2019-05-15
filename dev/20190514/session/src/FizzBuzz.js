function generateList() {
  return [...Array(101).keys()].slice(1).map(ix => fizzBuzz(ix));
}

function fizzBuzz(number) {
  if (number % 15 === 0) return "FizzBuzz";
  if (number % 3 === 0) return "Fizz";
  if (number % 5 === 0) return "Buzz";
  return number;
}

module.exports.fizzBuzz = fizzBuzz;
module.exports.generateList = generateList;
