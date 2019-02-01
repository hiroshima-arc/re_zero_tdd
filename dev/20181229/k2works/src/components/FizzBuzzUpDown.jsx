import * as React from "react";
import {fizzBuzz} from "../fizzbuzz_model";

export class FizzBuzzUpDown extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      message: "Ready"
    };
  }

  fizzBuzzDown = () => {
    let fizzBuzzUpDownCount = this.state.count;
    if (fizzBuzzUpDownCount === 0) {
      this.setState({count: 0});
    } else {
      fizzBuzzUpDownCount -= 1;
    }
    const count = fizzBuzzUpDownCount;
    this.setState({message: fizzBuzz(count)});
    this.setState({count});
  };

  fizzBuzzUp = () => {
    let fizzBuzzUpDownCount = this.state.count;
    fizzBuzzUpDownCount += 1;
    const count = fizzBuzzUpDownCount;
    this.setState({message: fizzBuzz(count)});
    this.setState({count});
  };

  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--up-down">
          <h2>FizzBuzzUpDown</h2>
          <div id="fizz-buzz-component__up-down--message">{this.state.message}</div>
          <input
            id="fizz-buzz-component__button--down"
            type="button"
            value="-"
            onClick={this.fizzBuzzDown}
          />
          <input
            id="fizz-buzz-component__button--up"
            type="button"
            value="+"
            onClick={this.fizzBuzzUp}
          />
        </article>
      </div>
    );
  }
}