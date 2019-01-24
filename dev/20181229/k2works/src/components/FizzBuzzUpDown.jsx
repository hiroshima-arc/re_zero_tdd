import * as React from "react";

export class FizzBuzzUpDown extends React.Component {
  render() {
    return (
      <div>
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
      </div>
    );
  }
}