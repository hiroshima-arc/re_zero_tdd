function isFizz(number) {
  return number % 3 === 0;
}

function isBuzz(number) {
  return number % 5 === 0;
}

export function fizzBuzz(number) {
  if ((isFizz(number)) && (isBuzz(number))) return "FizzBuzz";
  if (isFizz(number)) return "Fizz";
  if (isBuzz(number)) return "Buzz";
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

