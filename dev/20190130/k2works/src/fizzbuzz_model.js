export function execute(max_count) {
  iterate(max_count).forEach((value) => {
    console.log(value);
  });
}

export function iterate(count) {
  let array = [];
  [...Array(count + 1).keys()].forEach((n) => {
    array.push(fizzBuzz(n));
  });
  array.shift();
  return array;
}

export function fizzBuzz(number) {
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