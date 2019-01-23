import React, {Component} from "react";
import PropTypes from "prop-types";

const logo = "logo";

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <h1 className="App-title">Welcome to {this.props.text}</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

App.propTypes = {
  text: PropTypes.string
};

App.defaultProps = {
  text: "React"
};

import {shallow} from "enzyme";

const emptyProps = {
  text: "test"
};

describe("App", () => {
  describe("App-title", () => {
    const cases = [
      ["simple test1", {text: "Jest"}, "Welcome to Jest"],
      ["simple test2", {text: "enzyme"}, "Welcome to enzyme"]
    ];
    describe.each(cases)("change Props", (title, override, expected) => {
      it(title, () => {
        const customProps = Object.assign({}, emptyProps, override);
        const wrapper = shallow(<App {...customProps} />);
        expect(wrapper.instance().props.text).toBe(customProps.text);
        expect(wrapper.find(".App-title").text()).toBe(expected);
      });
    });
  });
});