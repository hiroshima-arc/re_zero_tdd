import React from "react";
import styles from "./FizzBuzz.css";
import {FizzBuzzCall} from "./FizzBuzzCall";
import {FizzBuzzPrint} from "./FizzBuzzPrint";
import {FizzBuzzUpDown} from "./FizzBuzzUpDown";
import {FizzBuzzIterate} from "./FizzBuzzIterate";

export class FizzBuzz extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      call: "block",
      print: "block",
      updown: "block",
      iterate: "block"
    };
  }

  showFizzBuzzCall = () => {
    const state = ({
      call: "block",
      print: "none",
      updown: "none",
      iterate: "none"
    });
    this.setState(state);
  };

  showFizzBuzzPrint = () => {
    const state = ({
      call: "none",
      print: "block",
      updown: "none",
      iterate: "none"
    });
    this.setState(state);
  };

  showFizzBuzzUpDown = () => {
    const state = ({
      call: "none",
      print: "none",
      updown: "block",
      iterate: "none"
    });
    this.setState(state);
  };

  showFizzBuzzIterate = () => {
    const state = ({
      call: "none",
      print: "none",
      updown: "none",
      iterate: "block"
    });
    this.setState(state);
  };

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
        </header>
        <div className={styles["component"]}>
          <section>
            <div className={styles["fizz-buzz-component"]}>
              <h1>FizzBuzz</h1>
              <div style={{display: this.state.call}}>
                <FizzBuzzCall/>
              </div>
              <div style={{display: this.state.print}}>
                <FizzBuzzPrint/>
              </div>
              <div style={{display: this.state.updown}}>
                <FizzBuzzUpDown/>
              </div>
              <div style={{display: this.state.iterate}}>
                <FizzBuzzIterate/>
              </div>
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