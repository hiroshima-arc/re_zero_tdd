import React, { Component } from "react";
import { FizzBuzz } from "../domain/FizzBuzz";

export class Home extends Component {
  public static displayName = Home.name;

  private table = (() => {
    const header = (() => {
      let element = "<thead><tr>";
      FizzBuzz.range(1, 10).forEach(i => (element += `<th>${i}</th>`));
      element += "</tr></thead>";
      return element;
    })();

    const body = (() => {
      let element = "<tbody><tr>";
      for (let i = 1; i <= 100; i++) {
        element += `<td>${FizzBuzz.generate(i)}</td>`;
        if (i % 10 === 0) {
          element += "</tr>";
        }
      }
      element += "</tbody>";
      return element;
    })();

    return `
          <table class="table">
          ${header}
          ${body}
          </table>
`;
  })();

  public render() {
    return (
      <div>
        <h2>FizzBuzz</h2>
        <div id="app" dangerouslySetInnerHTML={{ __html: this.table }} />
      </div>
    );
  }
}
