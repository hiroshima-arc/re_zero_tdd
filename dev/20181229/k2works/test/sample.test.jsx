import React, {Component} from "react";

const List = (props) => (
  <ul>
    {
      props.items.map((item, index) => <li key={index}>{item}</li>)
    }
  </ul>
);

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      term: "",
      items: []
    };
  }

  onChange = (event) => {
    this.setState({term: event.target.value});
  };

  onSubmit = (event) => {
    event.preventDefault();
    this.setState({
      term: "",
      items: [...this.state.items, this.state.term]
    });
  };

  render() {
    return (
      <div>
        <form className="App" onSubmit={this.onSubmit}>
          <input value={this.state.term} onChange={this.onChange}/>
          <button>Submit</button>
        </form>
        <List items={this.state.items}/>
      </div>
    );
  }
}

import renderer from "react-test-renderer";
import {shallow} from "enzyme";

describe("Component: App", () => {
  const items = ["Learn react", "rest", "go out"];

  it("should match its empty snapshot", () => {
    const tree = renderer.create(
      <App/>
    ).toJSON();

    expect(tree).toMatchSnapshot();
  });

  it("should add an item based on the value in the state", () => {
    const component = shallow(<App/>);
    const preventDefault = jest.fn();
    component.setState({
      items
    });
    component.find("form").simulate("submit", {preventDefault});
    expect(component).toMatchSnapshot();
    expect(preventDefault).toBeCalled();
  });

  it("should pass a selected value to the onChange function", () => {
    const component = shallow(<App/>);
    component.find("input").simulate("change", {
      target: {
        value: "Change function"
      }
    });

    expect(component).toMatchSnapshot();
  });
});
