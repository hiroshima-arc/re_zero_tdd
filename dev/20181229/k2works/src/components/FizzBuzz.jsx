import React from "react";
import styles from "./FizzBuzz.css";
import "./FizzBuzzMenu";
import {FizzBuzzMenu} from "./FizzBuzzMenu";
import {FizzBuzzCall} from "./FizzBuzzCall";
import {FizzBuzzPrint} from "./FizzBuzzPrint";
import {FizzBuzzUpDown} from "./FizzBuzzUpDown";
import {FizzBuzzIterate} from "./FizzBuzzIterate";

export class FizzBuzz extends React.Component {
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