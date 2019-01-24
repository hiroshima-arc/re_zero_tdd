import * as React from "react";

export class FizzBuzzPrint extends React.Component {
  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--print">
          <h2>FizzBuzzPrint</h2>
          <div id="fizz-buzz-component__print--message">Initialized</div>
          <input id="fizz-buzz-component__input--print" type="text"/>
          <input
            id="fizz-buzz-component__button--print"
            type="button"
            value="Print"
          />
        </article>
      </div>
    );
  }
}