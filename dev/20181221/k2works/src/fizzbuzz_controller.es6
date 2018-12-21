import {fizzBuzz} from "./fizzbuzz_model";

const COUNT = 100;

function iterate(count) {
  let number = 1;
  let array = [];

  while (number <= count) {
    array.push(fizzBuzz(number));
    number++;
  }
  return array;
}

function execute() {
  iterate(COUNT).forEach(function (value) {
    console.log(value);
  });
}

export {iterate, execute};