import React from "react";
import styles from "./FizzBuzz.css";
import $ from "jquery";
import * as constants from "../constants";
import {fizzBuzz} from "../fizzbuzz_model";
import {iterate} from "../fizzbuzz_model";

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
    this.fizzBuzzDown = this.fizzBuzzDown.bind(this);
    this.fizzBuzzUp = this.fizzBuzzUp.bind(this);
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

  fizzBuzzCall() {
    const value = $("#fizz-buzz-component__input--call").val();
    if (isNaN(value)) {
      alert("数字を入力してください。");
    } else {
      alert(fizzBuzz(value));
    }
  }

  fizzBuzzPrint() {
    const value = $("#fizz-buzz-component__input--print").val();
    const target = $("#fizz-buzz-component__print--message");
    if (isNaN(value)) {
      a;
      target.html("数字を入力してください。");
    } else {
      target.html(fizzBuzz(value));
    }
  }

  fizzBuzzDown() {
    let fizzBuzzUpDownCount = this.state.fizzBuzzUpDownCount;
    if (fizzBuzzUpDownCount === 0) {
      fizzBuzzUpDownCount = 0;
    } else {
      fizzBuzzUpDownCount -= 1;
    }
    const target = $("#fizz-buzz-component__up-down--message");
    const count = fizzBuzzUpDownCount;
    target.html(fizzBuzz(count));
    this.state.fizzBuzzUpDownCount = count;
  }

  fizzBuzzUp() {
    let fizzBuzzUpDownCount = this.state.fizzBuzzUpDownCount;
    fizzBuzzUpDownCount += 1;
    const target = $("#fizz-buzz-component__up-down--message");
    const count = fizzBuzzUpDownCount;
    const value = fizzBuzz(count);
    target.html(value);
    this.state.fizzBuzzUpDownCount = count;
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
          <div className={styles["nav-component"]}>
            <nav>
              <h1>Menu</h1>
              <ul>
                <a href="#">FizzBuzz</a>
                <ul id="nav-component__sub-menu--fizz-buzz">
                  <li id="nav-component__sub-menu--fizz-buzz-call">
                    <a href="#">FizzBuzzCall</a>
                  </li>
                  <li id="nav-component__sub-menu--fizz-buzz-print">
                    <a href="#">FizzBuzzPrint</a>
                  </li>
                  <li id="nav-component__sub-menu--fizz-buzz-up-down">
                    <a href="#">FizzBuzzUpDown</a>
                  </li>
                  <li id="nav-component__sub-menu--fizz-buzz-iterate">
                    <a href="#">FizzBuzzIterate</a>
                  </li>
                </ul>
              </ul>
            </nav>
          </div>
        </header>
        <div className={styles["component"]}>
          <section>
            <div className={styles["fizz-buzz-component"]}>
              <h1>FizzBuzz</h1>
              <article id="fizz-buzz-component__article--call">
                <h2>FizzBuzzCall</h2>
                <input id="fizz-buzz-component__input--call" type="text"/>
                <input
                  id="fizz-buzz-component__button--call"
                  type="button"
                  value="Call"
                />
              </article>

              <article id="fizz-buzz-component__article--print">
                <h2>FizzBuzzPrint</h2>
                <div id="fizz-buzz-component__print--message">Initialized</div>
                <input id="fizz-buzz-component__input--print" type="text"/>
                <input
                  id="fizz-buzz-component__button--print"
                  type="button"
                  value="Print"
                />
              </article>

              <article id="fizz-buzz-component__article--up-down">
                <h2>FizzBuzzUpDown</h2>
                <div id="fizz-buzz-component__up-down--message">Ready</div>
                <input
                  id="fizz-buzz-component__button--down"
                  type="button"
                  value="-"
                />
                <input
                  id="fizz-buzz-component__button--up"
                  type="button"
                  value="+"
                />
              </article>

              <article id="fizz-buzz-component__article--iterate">
                <h2>FizzBuzzIterate</h2>
                <input id="fizz-buzz-component__input--iterate" type="text"/>
                <input
                  id="fizz-buzz-component__button--iterate"
                  type="button"
                  value="execute"
                />
                <div id="fizz-buzz-component__iterate--result"></div>
              </article>
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