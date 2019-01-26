import React from "react";
import styles from "./FizzBuzz.css";
import $ from "jquery";
import * as constants from "../constants";
import {fizzBuzz} from "../fizzbuzz_model";
import {iterate} from "../fizzbuzz_model";
import "./FizzBuzzMenu";
import {FizzBuzzMenu} from "./FizzBuzzMenu";
import {FizzBuzzCall} from "./FizzBuzzCall";
import {FizzBuzzPrint} from "./FizzBuzzPrint";
import {FizzBuzzUpDown} from "./FizzBuzzUpDown";
import {FizzBuzzIterate} from "./FizzBuzzIterate";

const MAX_COUNT = constants.FIZZ_BUZZ_MAX_COUNT;

export class FizzBuzz extends React.Component {
  constructor(props) {
    super(props);
    this.state = {fizzBuzzUpDownCount: props.fizzBuzzUpDownCount};
    this.handleLoad = this.handleLoad.bind(this);
    this.showFizzBuzzCall = this.showFizzBuzzCall.bind(this);
    this.showFizzBuzzPrint = this.showFizzBuzzPrint.bind(this);
    this.showFizzBuzzUpDown = this.showFizzBuzzUpDown.bind(this);
    this.showFizzBuzzIterate = this.showFizzBuzzIterate.bind(this);
    this.fizzBuzzIterate = this.fizzBuzzIterate.bind(this);
  }

  componentDidMount() {
    window.addEventListener("load", this.handleLoad);
  }

  handleLoad() {
    [{
      "nav-component__sub-menu--fizz-buzz-call": this.showFizzBuzzCall
    },
      {
        "nav-component__sub-menu--fizz-buzz-print": this.showFizzBuzzPrint
      },
      {
        "nav-component__sub-menu--fizz-buzz-up-down": this.showFizzBuzzUpDown
      },
      {
        "nav-component__sub-menu--fizz-buzz-iterate": this.showFizzBuzzIterate
      },
      {
        "fizz-buzz-component__button--call": this.fizzBuzzCall
      },
      {
        "fizz-buzz-component__button--print": this.fizzBuzzPrint
      },
      {
        "fizz-buzz-component__button--down": this.fizzBuzzDown
      },
      {
        "fizz-buzz-component__button--up": this.fizzBuzzUp
      },
      {
        "fizz-buzz-component__button--iterate": this.fizzBuzzIterate
      }
    ].forEach(hash => {
      Object.keys(hash).forEach(key => {
        let menu = $(`#${key}`);
        menu.on("click", hash[key]);
      });
    });
  }

  showFizzBuzzCall() {
    this.showFizzBuzz({
      "call": "block",
      "print": "none",
      "updown": "none",
      "iterate": "none"
    });
  }

  showFizzBuzzPrint() {
    this.showFizzBuzz({
      "call": "none",
      "print": "block",
      "updown": "none",
      "iterate": "none"
    });
  }

  showFizzBuzzUpDown() {
    this.showFizzBuzz({
      "call": "none",
      "print": "none",
      "updown": "block",
      "iterate": "none"
    });
  }

  showFizzBuzzIterate() {
    this.showFizzBuzz({
      "call": "none",
      "print": "none",
      "updown": "none",
      "iterate": "block"
    });
  }

  showFizzBuzz(
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

  fizzBuzzIterate() {
    const target = $("#fizz-buzz-component__iterate--result");
    let count = $("#fizz-buzz-component__input--iterate").val();
    if (isNaN(count)) {
      return target.html("数字を入力してください。");
    }
    if (count > MAX_COUNT) {
      return target.html(`<strong>件数は${MAX_COUNT}までです。</strong>`);
    }
    let array = iterate(parseInt(count));
    target.html(this.renderHtmlTable(array));
  }

  renderHtmlTable(array) {
    let rowCount = 1;
    let html = "<table>";

    html = html + "<thead>";
    [...Array(10).keys()].forEach((v) => {
      html = html + `<th>${v + 1}</th>`;
    });
    html = html + "</thead>";

    html = html + "<tbody>";

    html = html + "<tr>";
    array.forEach((value) => {
      if (rowCount > 10) {
        html = html + "<tr>";
      }

      value = `<td>${value}</td>`;
      html = html + value;

      if (rowCount === 10) {
        html = html + "</tr>";
        rowCount = 1;
      } else {
        rowCount += 1;
      }
    });

    html = html + "</tbody>";
    html = html + "</table>";
    return html;
  }

  render() {
    return (
      <div>
        <h1>HTML5+CSS+JavaScript with TDD</h1>
        <header>
          <FizzBuzzMenu/>
        </header>
        <div className={styles["component"]}>
          <section>
            <div className={styles["fizz-buzz-component"]}>
              <h1>FizzBuzz</h1>
              <FizzBuzzCall/>
              <FizzBuzzPrint/>
              <FizzBuzzUpDown/>
              <FizzBuzzIterate/>
            </div>
          </section>
        </div>
        <footer>
          <p>Copyrights</p>
          <address>hiroshima-arc@gmail.com</address>
        </footer>
      </div>
    );
  }
}