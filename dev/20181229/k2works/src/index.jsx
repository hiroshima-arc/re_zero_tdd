import React from "react";
import ReactDOM from "react-dom";
import {FizzBuzz} from "./components/FizzBuzz";


class App extends React.Component {
  render() {
    return (
      <div>
        <FizzBuzz/>
      </div>
    );
  }
}

ReactDOM.render(<App/>, document.querySelector("#app"));