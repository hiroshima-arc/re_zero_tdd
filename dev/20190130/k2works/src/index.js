import "./contents.css";
import "./fizzbuzz_controller";
import "./fizzbuzz_view";
import $ from "jquery";
import {execute} from "./fizzbuzz_model";
import {FIZZ_BUZZ_MAX_COUNT as MAX_COUNT} from "./constants";
import {
  createFizzBuzzUpDown,
  fizzBuzzCall, fizzBuzzIterate, fizzBuzzPrint, showFizzBuzz,
  showFizzBuzzCall,
  showFizzBuzzIterate,
  showFizzBuzzPrint,
  showFizzBuzzUpDown
} from "./fizzbuzz_controller";

execute(MAX_COUNT);
bindActions();

function bindActions() {
  const upDown = createFizzBuzzUpDown(
    $("#fizz-buzz-component__up-down--message")
  );
  const show = showFizzBuzz(
    $("#fizz-buzz-component__article--call"),
    $("#fizz-buzz-component__article--print"),
    $("#fizz-buzz-component__article--up-down"),
    $("#fizz-buzz-component__article--iterate")
  );
  [
    {
      key: "nav-component__sub-menu--fizz-buzz-call",
      onClick: () => show(showFizzBuzzCall())
    },
    {
      key: "nav-component__sub-menu--fizz-buzz-print",
      onClick: () => show(showFizzBuzzPrint())
    },
    {
      key: "nav-component__sub-menu--fizz-buzz-up-down",
      onClick: () => show(showFizzBuzzUpDown())
    },
    {
      key: "nav-component__sub-menu--fizz-buzz-iterate",
      onClick: () => show(showFizzBuzzIterate())
    },
    {
      key: "fizz-buzz-component__button--call",
      onClick: () => fizzBuzzCall($("#fizz-buzz-component__input--call"))
    },
    {
      key: "fizz-buzz-component__button--print",
      onClick: () => fizzBuzzPrint($("#fizz-buzz-component__print--message"), $("#fizz-buzz-component__input--print"))
    },
    {
      key: "fizz-buzz-component__button--down",
      onClick: () => upDown.down()
    },
    {
      key: "fizz-buzz-component__button--up",
      onClick: () => upDown.up()
    },
    {
      key: "fizz-buzz-component__button--iterate",
      onClick: () => fizzBuzzIterate($("#fizz-buzz-component__iterate--result"), $("#fizz-buzz-component__input--iterate"), MAX_COUNT)
    }
  ].forEach(({key, onClick}) => {
    const menu = $(`#${key}`);
    menu.on("click", onClick);
  });
}