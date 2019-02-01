import {fizzBuzz, iterate} from "./fizzbuzz_model";
import {htmlTable} from "./fizzbuzz_view";

export function showFizzBuzzCall() {
  return {
    "call": "block",
    "print": "none",
    "updown": "none",
    "iterate": "none"
  };
}

export function showFizzBuzzPrint() {
  return {
    "call": "none",
    "print": "block",
    "updown": "none",
    "iterate": "none"
  };
}

export function showFizzBuzzUpDown() {
  return {
    "call": "none",
    "print": "none",
    "updown": "block",
    "iterate": "none"
  };
}

export function showFizzBuzzIterate() {
  return {
    "call": "none",
    "print": "none",
    "updown": "none",
    "iterate": "block"
  };
}

export function showFizzBuzz(
  $call,
  $print,
  $updown,
  $iterate) {
  return (
    state = {
      "call": "none",
      "print": "none",
      "updown": "none",
      "iterate": "none"
    }
  ) => {
    $call.css("display", state.call);
    $print.css("display", state.print);
    $updown.css("display", state.updown);
    $iterate.css("display", state.iterate);
  };
}

export function fizzBuzzCall(target) {
  const value = target.val();
  if (isNaN(value)) {
    alert("数字を入力してください。");
  } else {
    alert(fizzBuzz(value));
  }
}

export function fizzBuzzPrint(target, input) {
  const value = input.val();
  if (isNaN(value)) {
    target.html("数字を入力してください。");
  } else {
    target.html(fizzBuzz(value));
  }
}

export function createFizzBuzzUpDown(target) {
  let counter = 0;
  return {
    up() {
      counter++;
      const value = fizzBuzz(counter);
      target.html(value);
    },
    down() {
      if (counter === 0) {
        counter = 0;
      } else {
        counter -= 1;
      }
      target.html(fizzBuzz(counter));
    }
  };
}

function splitArrayNumberOfColumnsPerLine(array, number) {
  const head = array.slice(0, number);
  const tail = array.slice(number);
  if (tail.length > 0) {
    return [head].concat(splitArrayNumberOfColumnsPerLine(tail, number));
  }
  return [head];
}

export function fizzBuzzIterate(target, input, maxCount, columnsNumber) {
  const count = parseInt(input.val());
  if (count > maxCount) {
    return target.html(`<strong>件数は${maxCount}までです。</strong>`);
  }
  const array = iterate(count);
  const splitArray = splitArrayNumberOfColumnsPerLine(array, columnsNumber);
  const html = htmlTable(splitArray, columnsNumber);
  target.html(html);
}