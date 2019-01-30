import "./contents.css";
import "./fizzbuzz_controller";
import "./fizzbuzz_view";
import $ from "jquery";
import {execute} from "./fizzbuzz_model";
import {FIZZ_BUZZ_MAX_COUNT as MAX_COUNT} from "./constants";
import {
  fizzBuzzCall, fizzBuzzDown, fizzBuzzIterate, fizzBuzzPrint, fizzBuzzUp,
  showFizzBuzzCall,
  showFizzBuzzIterate,
  showFizzBuzzPrint,
  showFizzBuzzUpDown
} from "./fizzbuzz_controller";

execute(MAX_COUNT);
bindActions();

function bindActions() {
  [
    {
      "nav-component__sub-menu--fizz-buzz-call": showFizzBuzzCall
    },
    {
      "nav-component__sub-menu--fizz-buzz-print": showFizzBuzzPrint
    },
    {
      "nav-component__sub-menu--fizz-buzz-up-down": showFizzBuzzUpDown
    },
    {
      "nav-component__sub-menu--fizz-buzz-iterate": showFizzBuzzIterate
    },
    {
      "fizz-buzz-component__button--call": fizzBuzzCall
    },
    {
      "fizz-buzz-component__button--print": fizzBuzzPrint
    },
    {
      "fizz-buzz-component__button--down": fizzBuzzDown
    },
    {
      "fizz-buzz-component__button--up": fizzBuzzUp
    },
    {
      "fizz-buzz-component__button--iterate": fizzBuzzIterate
    }
  ].forEach(hash => {
    Object.keys(hash).forEach(key => {
      let menu = $(`#${key}`);
      menu.on("click", hash[key]);
    });
  });
}