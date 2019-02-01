import * as React from "react";
import {iterate} from "../fizzbuzz_model";
import * as constants from "../constants";

const MAX_COUNT = constants.FIZZ_BUZZ_MAX_COUNT;

export class FizzBuzzIterate extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      input: "",
      table: ""
    };
  }

  onClick = () => {
    const count = this.state.input;
    if (count === "") {
      return this.setState({table: "数字を入力してください。"});
    }
    if (isNaN(count)) {
      return this.setState({table: "数字を入力してください。"});
    }
    if (count > MAX_COUNT) {
      return this.setState({table: `<strong>件数は${MAX_COUNT}までです。</strong>`});
    }
    let array = iterate(parseInt(count));
    let table = this.renderHtmlTable(array);
    this.setState({table});
  };

  onChange = (event) => {
    this.setState({input: event.target.value});
  };

  renderHtmlTable(array) {
    let rowCount = 1;
    let html = "<table>";

    html = html + "<thead>";
    [...Array(10).keys()].forEach((v) => {
      html = html + `<th>${v + 1}</th>`;
    });
    html = html + "</thead>";

    html = html + "<tbody>";

    html = html + "<tr>";
    array.forEach((value) => {
      if (rowCount > 10) {
        html = html + "<tr>";
      }

      value = `<td>${value}</td>`;
      html = html + value;

      if (rowCount === 10) {
        html = html + "</tr>";
        rowCount = 1;
      } else {
        rowCount += 1;
      }
    });

    html = html + "</tbody>";
    html = html + "</table>";
    return html;
  }

  render() {
    return (
      <div>
        <article id="fizz-buzz-component__article--iterate">
          <h2>FizzBuzzIterate</h2>
          <input
            id="fizz-buzz-component__input--iterate"
            type="text"
            onChange={this.onChange}
          />
          <input
            id="fizz-buzz-component__button--iterate"
            type="button"
            value="execute"
            onClick={this.onClick}
          />
          <div id="fizz-buzz-component__iterate--result"
               dangerouslySetInnerHTML={{__html: this.state.table}}
          />
        </article>
      </div>
    );
  }
}