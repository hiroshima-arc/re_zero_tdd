import * as React from "react";
import {fizzBuzz} from "../fizzbuzz_model";

export class FizzBuzzCall extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      input: ""
    };
  }

  onClick = () => {
    const value = this.state.input;
    if (isNaN(value)) {
      alert("数字を入力してください。");
    } else {
      alert(fizzBuzz(value));
    }
  };

  onChange = (event) => {
    this.setState({input: event.target.value});
  };

  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--call">
          <h2>FizzBuzzCall</h2>
          <input
            id="fizz-buzz-component__input--call"
            type="text"
            value={this.state.input}
            onChange={this.onChange}
          />
          <input
            id="fizz-buzz-component__button--call"
            type="button"
            value="Call"
            onClick={this.onClick}
          />
        </article>
      </div>
    );
  }
}