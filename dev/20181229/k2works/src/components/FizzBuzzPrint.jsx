import * as React from "react";
import {fizzBuzz} from "../fizzbuzz_model";

export class FizzBuzzPrint extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "Initialized",
      input: ""
    };
  }

  onClick = () => {
    const value = this.state.input;
    if (isNaN(value)) {
      this.setState({message: "数字を入力してください。"});
    } else {
      let fizzBuzzValue = fizzBuzz(value);
      this.setState({message: fizzBuzzValue});
    }
  };

  onChange = (event) => {
    this.setState({input: event.target.value});
  };

  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--print">
          <h2>FizzBuzzPrint</h2>
          <div id="fizz-buzz-component__print--message">{this.state.message}</div>
          <input
            id="fizz-buzz-component__input--print"
            type="text"
            value={this.state.input}
            onChange={this.onChange}
          />
          <input
            id="fizz-buzz-component__button--print"
            type="button"
            value="Print"
            onClick={this.onClick}
          />
        </article>
      </div>
    );
  }
}