import * as React from "react";

export class FizzBuzzCall extends React.Component {
  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--call">
          <h2>FizzBuzzCall</h2>
          <input id="fizz-buzz-component__input--call" type="text"/>
          <input
            id="fizz-buzz-component__button--call"
            type="button"
            value="Call"
          />
        </article>
      </div>
    );
  }
}