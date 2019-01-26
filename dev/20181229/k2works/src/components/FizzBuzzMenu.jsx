import * as React from "react";
import styles from "./FizzBuzz.css";
import $ from "jquery";

export class FizzBuzzMenu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {fizzBuzzUpDownCount: props.fizzBuzzUpDownCount};
    this.handleLoad = this.handleLoad.bind(this);
    this.showFizzBuzzCall = this.showFizzBuzzCall.bind(this);
    this.showFizzBuzzPrint = this.showFizzBuzzPrint.bind(this);
    this.showFizzBuzzUpDown = this.showFizzBuzzUpDown.bind(this);
    this.showFizzBuzzIterate = this.showFizzBuzzIterate.bind(this);
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

  render() {
    return (
      <div>
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
      </div>
    );
  }
}