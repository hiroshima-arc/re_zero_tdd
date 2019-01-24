import * as React from "react";
import styles from "./FizzBuzz.css";

export class FizzBuzzMenu extends React.Component {
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