import $ from "jquery";
import {fizzBuzz, iterate} from "./fizzbuzz_model";
import {FIZZ_BUZZ_MAX_COUNT as MAX_COUNT} from "./constants";
import {renderHtmlTable} from "./fizzbuzz_view";

let fizzBuzzUpDownCount = 0;

export function showFizzBuzzCall() {
  showFizzBuzz({
    "call": "block",
    "print": "none",
    "updown": "none",
    "iterate": "none"
  });
}

export function showFizzBuzzPrint() {
  showFizzBuzz({
    "call": "none",
    "print": "block",
    "updown": "none",
    "iterate": "none"
  });
}

export function showFizzBuzzUpDown() {
  showFizzBuzz({
    "call": "none",
    "print": "none",
    "updown": "block",
    "iterate": "none"
  });
}

export function showFizzBuzzIterate() {
  showFizzBuzz({
    "call": "none",
    "print": "none",
    "updown": "none",
    "iterate": "block"
  });
}

export function showFizzBuzz(
  state = {
    "call": "none",
    "print": "none",
    "updown": "none",
    "iterate": "none"
  }
) {
  $("#fizz-buzz-component__article--call").css("display", state["call"]);
  $("#fizz-buzz-component__article--print").css("display", state["print"]);
  $("#fizz-buzz-component__article--up-down").css("display", state["updown"]);
  $("#fizz-buzz-component__article--iterate").css("display", state["iterate"]);
}

export function fizzBuzzCall() {
  const value = $("#fizz-buzz-component__input--call").val();
  if (isNaN(value)) {
    alert("数字を入力してください。");
  } else {
    alert(fizzBuzz(value));
  }
}

export function fizzBuzzPrint() {
  const value = $("#fizz-buzz-component__input--print").val();
  const target = $("#fizz-buzz-component__print--message");
  if (isNaN(value)) {
    target.html("数字を入力してください。");
  } else {
    target.html(fizzBuzz(value));
  }
}

export function fizzBuzzDown() {
  if (fizzBuzzUpDownCount === 0) {
    fizzBuzzUpDownCount = 0;
  } else {
    fizzBuzzUpDownCount -= 1;
  }
  const target = $("#fizz-buzz-component__up-down--message");
  const count = fizzBuzzUpDownCount;
  target.html(fizzBuzz(count));
}

export function fizzBuzzUp() {
  fizzBuzzUpDownCount += 1;
  const target = $("#fizz-buzz-component__up-down--message");
  const count = fizzBuzzUpDownCount;
  const value = fizzBuzz(count);
  target.html(value);
}

export function fizzBuzzIterate() {
  const target = $("#fizz-buzz-component__iterate--result");
  let count = $("#fizz-buzz-component__input--iterate").val();
  if (count > MAX_COUNT) {
    return target.html(`<strong>件数は${MAX_COUNT}までです。</strong>`);
  }
  let array = iterate(parseInt(count));
  target.html(renderHtmlTable(array));
}