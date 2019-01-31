export function fizzBuzz(number) {
  if ((number % 3 === 0) && (number % 5 === 0)) return "FizzBuzz";
  if (number % 3 === 0) return "Fizz";
  if (number % 5 === 0) return "Buzz";
  return number;
}

export function iterate(count) {
  let array = [];
  [...Array(count + 1).keys()].forEach((n) => {
    array.push(fizzBuzz(n));
  });
  array.shift();
  return array;
}

export function execute(maxCount) {
  iterate(maxCount).forEach((value) => {
    console.log(value);
  });
}

