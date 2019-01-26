import * as React from "react";
import styles from "./FizzBuzz.css";
import $ from "jquery";

export class FizzBuzzMenu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      call: "none",
      print: "none",
      updown: "none",
      iterate: "none"
    };
  }

  showFizzBuzzCall = () => {
    const state = ({
      call: "block",
      print: "none",
      updown: "none",
      iterate: "none"
    });
    this.showFizzBuzz(state);
  };

  showFizzBuzzPrint = () => {
    const state = ({
      call: "none",
      print: "block",
      updown: "none",
      iterate: "none"
    });
    this.showFizzBuzz(state);
  };

  showFizzBuzzUpDown = () => {
    const state = ({
      call: "none",
      print: "none",
      updown: "block",
      iterate: "none"
    });
    this.showFizzBuzz(state);
  };

  showFizzBuzzIterate = () => {
    const state = ({
      call: "none",
      print: "none",
      updown: "none",
      iterate: "block"
    });
    this.showFizzBuzz(state);
  };

  showFizzBuzz = (state) => {
    $("#fizz-buzz-component__article--call").css("display", state["call"]);
    $("#fizz-buzz-component__article--print").css("display", state["print"]);
    $("#fizz-buzz-component__article--up-down").css("display", state["updown"]);
    $("#fizz-buzz-component__article--iterate").css("display", state["iterate"]);
    this.setState(state);
  };

  render() {
    return (
      <div>
        <div className={styles["nav-component"]}>
          <nav>
            <h1>Menu</h1>
            <ul>
              <a href="#">FizzBuzz</a>
              <ul id="nav-component__sub-menu--fizz-buzz">
                <li id="nav-component__sub-menu--fizz-buzz-call" onClick={this.showFizzBuzzCall}>
                  <a href="#">FizzBuzzCall</a>
                </li>
                <li id="nav-component__sub-menu--fizz-buzz-print" onClick={this.showFizzBuzzPrint}>
                  <a href="#">FizzBuzzPrint</a>
                </li>
                <li id="nav-component__sub-menu--fizz-buzz-up-down" onClick={this.showFizzBuzzUpDown}>
                  <a href="#">FizzBuzzUpDown</a>
                </li>
                <li id="nav-component__sub-menu--fizz-buzz-iterate" onClick={this.showFizzBuzzIterate}>
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