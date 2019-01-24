import * as React from "react";

export class FizzBuzzIterate extends React.Component {
  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--iterate">
          <h2>FizzBuzzIterate</h2>
          <input id="fizz-buzz-component__input--iterate" type="text"/>
          <input
            id="fizz-buzz-component__button--iterate"
            type="button"
            value="execute"
          />
          <div id="fizz-buzz-component__iterate--result"></div>
        </article>
      </div>
    );
  }
}